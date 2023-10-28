package com.cp.service;

import java.util.List;

import com.cp.model.*;
import com.cp.model.dto.UserDto;

import jakarta.validation.Valid;

public interface UserService {
	User save (UserDto userDto);

	List<User> getUserAll();

	User findByEmail(String email);

	void deleteUser(Integer id);

	User findById(Integer id);

	void updateUser(Integer id, @Valid User user);
	
}
