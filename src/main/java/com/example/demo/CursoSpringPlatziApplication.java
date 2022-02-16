package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.bean.MyBean;
import com.example.demo.component.ComponentDependency;

@SpringBootApplication
public class CursoSpringPlatziApplication implements CommandLineRunner{
	private ComponentDependency componentDependency;
	private MyBean mybean;
	
	@Autowired
	public CursoSpringPlatziApplication(@Qualifier("componentTwoImplement")ComponentDependency componentDependency, MyBean mybean) {
		this.componentDependency=componentDependency;
		this.mybean=mybean;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringPlatziApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		this.componentDependency.saludar();
		this.mybean.print();
		
	}
	
}
