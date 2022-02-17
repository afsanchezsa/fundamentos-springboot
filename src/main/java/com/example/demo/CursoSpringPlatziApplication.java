package com.example.demo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import com.example.demo.bean.MyBean;
import com.example.demo.bean.MyBeanWithDependency;
import com.example.demo.bean.MyBeanWithProperties;
import com.example.demo.component.ComponentDependency;
import com.example.demo.entity.User;
import com.example.demo.pojo.UserPojo;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class CursoSpringPlatziApplication implements CommandLineRunner{
	
	private final Log LOGGER= LogFactory.getLog(CursoSpringPlatziApplication.class);
	
	private ComponentDependency componentDependency;
	private MyBean mybean;
	private MyBeanWithDependency beanWithDependency;
	private MyBeanWithProperties beanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;
	@Autowired
	public CursoSpringPlatziApplication(@Qualifier("componentTwoImplement")ComponentDependency componentDependency,
			MyBean mybean,MyBeanWithDependency beanWithDependency,
			MyBeanWithProperties beanWithProperties,
			UserPojo userPojo,
			UserRepository userRepository) {
		this.componentDependency=componentDependency;
		this.mybean=mybean;
		this.beanWithDependency=beanWithDependency;
		this.beanWithProperties=beanWithProperties;
		this.userPojo=userPojo;
		this.userRepository=userRepository;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringPlatziApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		
		//ejemplosAnteriores();
		saveUsersInDb();
		getUserJPQL();
		
	}
	
	private void saveUsersInDb() {
		User u1 =new User("Andres", "andres@mail.com", LocalDate.of( 2021, 10, 10));
		User u2 =new User("Felipe", "felipe@mail.com", LocalDate.of( 2021, 11, 11));
		User u3 =new User("Felipe Juan", "felipeju@mail.com", LocalDate.of( 2018, 11, 11));
		List<User> list=Arrays.asList(u1,u2,u3);
		list.stream().forEach(userRepository::save);
	}
	private void getUserJPQL() {
		LOGGER.info("usuario encontrado"+
		this.userRepository.findByUserEmail("andres@mail.com")
		.orElseThrow(()->new RuntimeException("usuario no encontrado")));
		
		this.userRepository.findAndSort("Feli", Sort.by("id").descending())
		.stream()
		.forEach(user -> LOGGER.info("usuario con metodo sort"+ user));
		
		this.userRepository.findByName("Felipe")
		.stream()
		.forEach(user->LOGGER.info("usuario con query method "+user));
		
		LOGGER.info("Usuario con query method es : "+ this.userRepository.findByEmailAndName("andres@mail.com", "Andres")
		.orElseThrow(()-> new RuntimeException("usuario no encontrado")));
	
	}
	private void ejemplosAnteriores() {
		this.componentDependency.saludar();
		this.mybean.print();
		this.beanWithDependency.printWithDependency();
		System.out.println(this.beanWithProperties.function());
		System.out.println(this.userPojo.getEmail()+" "+this.userPojo.getPassword());
		
		try {
			
		}catch(Exception e) {
			LOGGER.error("Esto es un error");	
		}
		
	}
	
}
