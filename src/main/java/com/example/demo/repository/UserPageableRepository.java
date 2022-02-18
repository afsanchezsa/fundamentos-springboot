package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserPageableRepository extends PagingAndSortingRepository<User, Long>{
	
	//List<User> findAll(Pageable pageable);
	
}
