package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.component.ComponentDependency;

@SpringBootApplication
public class CursoSpringPlatziApplication implements CommandLineRunner{
	private ComponentDependency componentDependency;
	
	@Autowired
	public CursoSpringPlatziApplication(ComponentDependency componentDependency) {
		this.componentDependency=componentDependency;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringPlatziApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		this.componentDependency.saludar();
		
	}
	
}
