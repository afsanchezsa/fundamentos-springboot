package com.example.demo.caseuse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
@Component
public class GetUserPageable {
	private UserService userService;
	@Autowired
	public GetUserPageable(UserService userService) {
		this.userService = userService;
	}
	
	public List<User> getUsersByPage(int page, int size){
		return this.userService.findByPage(page, size);
	}
	
	
}
