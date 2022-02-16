package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.bean.MyBean;
import com.example.demo.bean.MyBean2Implement;
import com.example.demo.bean.MyBeanImplement;

@Configuration
public class MyConfiguratioBean {

	
	@Bean
	public MyBean beanOperation() {
		return new MyBean2Implement();
	}
}
