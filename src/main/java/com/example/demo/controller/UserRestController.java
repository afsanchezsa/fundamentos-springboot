package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.caseuse.CreateUser;
import com.example.demo.caseuse.DeleteUser;
import com.example.demo.caseuse.GetUser;
import com.example.demo.caseuse.GetUserPageable;
import com.example.demo.caseuse.UpdateUser;
import com.example.demo.entity.User;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
	
	private GetUser getUser;
	private CreateUser createUser;
	private DeleteUser deleteUser;
	private UpdateUser updateUser;
	private GetUserPageable getUserPageable;
	
	@Autowired
	public UserRestController(GetUser getUser,CreateUser createUser,DeleteUser deleteUser, UpdateUser updateUser,GetUserPageable getUserPageable) {
		
		this.getUser = getUser;
		this.createUser=createUser;
		this.deleteUser=deleteUser;
		this.updateUser=updateUser;
		this.getUserPageable=getUserPageable;
	}


	@GetMapping("/")
	List<User> get(){
		
		return this.getUser.getAll();
	}
	
	@PostMapping("/")
	ResponseEntity<User>newUser(@RequestBody User newUser){
		return new ResponseEntity<>(this.createUser.save(newUser),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity deleteUser(@PathVariable Long id) {
		this.deleteUser.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
	}
	
	@PutMapping("/{id}")
	ResponseEntity <User> replaceUser(@RequestBody User newUser,@PathVariable Long id){
		return  new ResponseEntity<>(this.updateUser.update(newUser,id),HttpStatus.OK);
		
		
	}
	
	@GetMapping("/pageable")
	List<User> getUserPageable(@RequestParam int page,@RequestParam int size){
		return this.getUserPageable.getUsersByPage(page, size);
		
	}
	
}
