package com.example.capstone_6.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.capstone_6.pojo.User;


public interface UserDao extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
