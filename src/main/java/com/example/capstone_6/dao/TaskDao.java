package com.example.capstone_6.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.capstone_6.pojo.Task;



public interface TaskDao extends JpaRepository<Task, Long> {
	List<Task> findByUserId(Long userId);

}
