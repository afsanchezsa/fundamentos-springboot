package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;

import com.example.demo.entity.User;
import com.example.demo.repository.UserPageableRepository;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	private final Log LOG=LogFactory.getLog(UserService.class);
	private UserRepository userRepository;
	private UserPageableRepository userPageableRepository;
	public UserService(UserRepository userRepository,UserPageableRepository userPageableRepository) {
	
		this.userRepository = userRepository;
		this.userPageableRepository=userPageableRepository;
	}
	
	@Transactional
	public void saveTransactional(List<User> users) {
		users.stream()
		.peek(user->LOG.info("Usuario Insertado "+user))
		.forEach(user ->userRepository.save(user) );
		
	}
	
	public List<User> getAllUsers(){
		return this.userRepository.findAll();
	}
	
	public User save(User newUser) {
		return this.userRepository.save(newUser);
	}

	public void delete(Long id) {
		this.userRepository.delete(new User(id));
		
	}

	public User update(User newUser, Long id) {
		// TODO Auto-generated method stub
		return this.userRepository.findById(id)
		.map(
				user->{
			user.setEmail(newUser.getEmail());
			user.setBirthDate(newUser.getBirthDate());
			user.setName(newUser.getName());
			return this.userRepository.save(user);
		}).orElse(null);
		
		
		
	}
	
	
	public List<User> findByPage(int page,int size) {
		return  this.userPageableRepository.findAll(PageRequest.of(page,size)).getContent();
	}
	
	

}
