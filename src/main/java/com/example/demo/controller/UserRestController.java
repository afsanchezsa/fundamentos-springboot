package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.caseuse.GetUser;
import com.example.demo.entity.User;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
	
	private GetUser getUser;
	
	
	@Autowired
	public UserRestController(GetUser getUser) {
		
		this.getUser = getUser;
	}


	@GetMapping("/")
	List<User> get(){
		
		return this.getUser.getAll();
	}
	
}
