package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.bean.MyBean;
import com.example.demo.bean.MyBean2Implement;

import com.example.demo.bean.MyBeanWithDependency;
import com.example.demo.bean.MyBeanWithDependencyImplement;
import com.example.demo.bean.MyOperation;
import com.example.demo.bean.MyOperationImplement;

@Configuration
public class MyConfiguratioBean {

	
	@Bean
	public MyBean beanOperation() {
		return new MyBean2Implement();
	}
	
	
	@Bean
	public MyOperation beanOperationOperation() {
		return new MyOperationImplement();
	}
	
	
	@Bean
	public MyBeanWithDependency beanWithDependency(MyOperation operation) {
		return new MyBeanWithDependencyImplement(operation);
	} 
}
