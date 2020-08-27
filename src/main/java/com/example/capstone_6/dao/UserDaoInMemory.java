package com.example.capstone_6.dao;

import java.util.HashMap;


import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.capstone_6.pojo.User;



// Pretending to be a DAO for convenience, but really just keeps the data in a map. In a real app, use a real DAO.
@Component
public class UserDaoInMemory {

	private Map<Long, User> users = new HashMap<>();
	private long nextId = 1;
	
	{
		// This is called an instance initialization block. It runs when a class instance is created,
		// right before the constructor.
		// Here we add two premade users to the "database".
		create(new User("mike@gmail.com", "LionsRule1"));
		create(new User("kelly@yahoo.com", "sweet!"));
	}
	
	public User findById(Long id) {
		return users.get(id);
	}
	
	public User findByEmail(String email) {
		return users.values().stream().filter(user -> email.equals(user.getEmail())).findAny().orElse(null);
	}
	
	public User findByGithubId(Long githubId) {
		return users.values().stream().filter(user -> user.getGithubId() == githubId).findAny().orElse(null);
	}
	
	public void create(User user) {
		user.setId(nextId++);
		users.put(user.getId(), user);
	}
	
	public void update(User user) {
		users.put(user.getId(), user);
	}

}
