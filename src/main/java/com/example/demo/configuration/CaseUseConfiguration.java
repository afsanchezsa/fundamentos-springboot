package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.caseuse.GetUser;
import com.example.demo.caseuse.GetUserImplement;
import com.example.demo.service.UserService;

@Configuration
public class CaseUseConfiguration {
	@Bean
	public GetUser getUser(UserService userService) {
		return new GetUserImplement(userService);
	}
}
