package com.example.demo.caseuse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Component
public class UpdateUser {
	private UserService userService;
	
	@Autowired
	public UpdateUser(UserService userService) {
		this.userService = userService;
	}

	public User update(User newUser, Long id) {
		// TODO Auto-generated method stub
		return this.userService.update(newUser,id) ;
	}
	
}
