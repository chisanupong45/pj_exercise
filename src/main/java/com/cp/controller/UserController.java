package com.cp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cp.model.*;
import com.cp.model.dto.ExerciseDto;
import com.cp.model.dto.NutritionDto;
import com.cp.model.dto.UserDto;
import com.cp.service.*;

@Controller
public class UserController {

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	private UserService userService;

	@Autowired
	private NutritionService nutritionService;
	
	@Autowired
	private ExerciseService exerciseService;

	@RequestMapping("/")
	public String root(Model model) {
		return "index";
	}
	
	@GetMapping("/user-page")
	public String userPage(Model model, Principal principal) {
		if (principal != null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
			model.addAttribute("user", userDetails);

			User user = userService.findByEmail(principal.getName());
			model.addAttribute("userId", user.getId());

			// Get the nutrition data for this user
			List<Nutrition> nutritionData = nutritionService.findByUserId(user.getId());
			model.addAttribute("nutritionData", nutritionData);
			
			List<Exercise> exerciseData = exerciseService.findByUserId(user.getId());
			model.addAttribute("exerciseData", exerciseData);

			return "user";
		} else {
			return "redirect:/login";
		}
	}

	
	@GetMapping("/user-page/add-food")
	public String getAddFoodPage(@ModelAttribute("user") UserDto userDto) {
		return "new_food";
	}
	
	@PostMapping("/user-page/add-food")
	public String addFood(@ModelAttribute("nutrition") NutritionDto nutritionDto, Principal principal, Model model) {
		User user = userService.findByEmail(principal.getName());

	    nutritionDto.setUserId(user.getId());

	    nutritionService.save(nutritionDto);
		return "redirect:/user-page";
	}
	
	@PostMapping("/user-page/del-nutrition/{id}")
	public String deleteUser(@PathVariable Integer id) {
	    nutritionService.deleteNutrition(id);
	    return "redirect:/user-page";
	}
	
	@RequestMapping("/user-page/add-exercise")
	public String getAddExercisePage(Model model) {
		return "new_exercise";
	}

	@PostMapping("/user-page/add-exercise")
	public String addExercise(@ModelAttribute("exercise") ExerciseDto exerciseDto, Principal principal, Model model) {
		User user = userService.findByEmail(principal.getName());

	    exerciseDto.setUserId(user.getId());

	    exerciseService.save(exerciseDto);
		return "redirect:/user-page";
	}
	
	@PostMapping("/user-page/del-exercise/{id}")
	public String deleteExercise(@PathVariable Integer id) {
	    exerciseService.deleteById(id);
	    return "redirect:/user-page";
	}
}
