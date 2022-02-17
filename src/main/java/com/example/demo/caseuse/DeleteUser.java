package com.example.demo.caseuse;

import org.springframework.stereotype.Component;

import com.example.demo.service.UserService;

@Component
public class DeleteUser {
	private UserService userService;

	public DeleteUser(UserService userService) {
		this.userService = userService;
	}

	public void remove(Long id) {
		this.userService.delete(id);
		
	}
	
}
