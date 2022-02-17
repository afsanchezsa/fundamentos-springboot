package com.example.demo.caseuse;

import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Component
public class CreateUser {
	private UserService userService;

	public CreateUser(UserService userService) {
		this.userService = userService;
	}
	
	public User save(User newUser) {
		return this.userService.save(newUser);
	}
	
}
