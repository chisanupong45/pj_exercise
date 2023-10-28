package com.cp.service.Impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cp.model.*;
import com.cp.model.dto.UserDto;
import com.cp.repository.RoleRepository;
import com.cp.repository.UserRepository;
import com.cp.service.UserService;

import jakarta.validation.Valid;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(UserDto userDto) {
		User user = new User();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setWeight(userDto.getWeight());
		user.setHeight(userDto.getHeight());
		user.setEmail(userDto.getEmail());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setRole(roleRepository.getReferenceById(2));

		return userRepository.save(user);
	}

	@Override
	public List<User> getUserAll() {
		return this.userRepository.findAll();
	}

	@Override
	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}

	@Override
	public void deleteUser(Integer id) {
		this.userRepository.deleteById(id);
	}

	@Override
	public User findById(Integer id) {
		Optional<User> optionalUser = this.userRepository.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			// Handle the case where the user is not found
			return null;
		}
	}

	@Override
	public void updateUser(Integer id, @Valid User user) {
		Optional<User> optionalUser = this.userRepository.findById(id);
	    if (optionalUser.isPresent()) {
	        User existingUser = optionalUser.get();
	        existingUser.setFirstName(user.getFirstName());
	        existingUser.setLastName(user.getLastName());
	        existingUser.setWeight(user.getWeight());
	        existingUser.setHeight(user.getHeight());
	        existingUser.setEmail(user.getEmail());
	        this.userRepository.save(existingUser);
	    } else {
	        // Handle the case where the user is not found
	    }
		
	}

}
