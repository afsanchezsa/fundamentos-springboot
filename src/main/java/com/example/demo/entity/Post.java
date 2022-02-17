package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_post",nullable=false,unique = true)
	private Long id;
	
	@Column(name = "description",length = 255)
	private String description;
	
	@ManyToOne
	private User user;

	public Post() {
		
	}
	
	public Post(String description, User user) {
		
		this.description = description;
		this.user = user;
	}

	
	
}
