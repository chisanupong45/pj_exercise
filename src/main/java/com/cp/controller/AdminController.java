package com.cp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;


import com.cp.model.*;
import com.cp.model.dto.UserDto;
import com.cp.service.UserService;

@Controller
public class AdminController {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;

	@GetMapping("/admin-page")
	public String adminPage(Model model, Principal principal) {
	    if (principal != null) {
	        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
	        model.addAttribute("user", userDetails);    
	        
	        List<User> usersList = userService.getUserAll();
			model.addAttribute("userList", usersList);
			
	        return "admin";
	    } else {
	        return "redirect:/login";
	    }
	}
	
	@GetMapping("/admin-page/add-User")
	public String getAddUserPage(@ModelAttribute("user") UserDto userDto) {
		return "add_user";
	}
	
	@PostMapping("/admin-page/add-User")
	public String addUser(@ModelAttribute("user") UserDto userDto, Model model) {
		userService.save(userDto);
		model.addAttribute("message", "Add Successfuly!");
		return "add_user";
	}
	
	@GetMapping("/admin-page/update-user/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "update_user_admin";
    }

    @PostMapping("/admin-page/update-user/{id}")
    public String updateUser(@PathVariable("id") Integer id, @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update_user_admin";
        }

        userService.updateUser(id, user);
        return "redirect:/admin-page";
    }
    
    @GetMapping("/admin-page/delete-user/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		userService.deleteUser(id);
	    return "redirect:/admin-page";
	}
}
