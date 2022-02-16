package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.bean.MyBean;
import com.example.demo.bean.MyBeanWithDependency;
import com.example.demo.bean.MyBeanWithProperties;
import com.example.demo.component.ComponentDependency;
import com.example.demo.pojo.UserPojo;

@SpringBootApplication
public class CursoSpringPlatziApplication implements CommandLineRunner{
	private ComponentDependency componentDependency;
	private MyBean mybean;
	private MyBeanWithDependency beanWithDependency;
	private MyBeanWithProperties beanWithProperties;
	private UserPojo userPojo;
	@Autowired
	public CursoSpringPlatziApplication(@Qualifier("componentTwoImplement")ComponentDependency componentDependency,
			MyBean mybean,MyBeanWithDependency beanWithDependency,
			MyBeanWithProperties beanWithProperties,
			UserPojo userPojo) {
		this.componentDependency=componentDependency;
		this.mybean=mybean;
		this.beanWithDependency=beanWithDependency;
		this.beanWithProperties=beanWithProperties;
		this.userPojo=userPojo;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringPlatziApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		this.componentDependency.saludar();
		this.mybean.print();
		this.beanWithDependency.printWithDependency();
		System.out.println(this.beanWithProperties.function());
		System.out.println(this.userPojo.getEmail()+" "+this.userPojo.getPassword());
		
	}
	
}
