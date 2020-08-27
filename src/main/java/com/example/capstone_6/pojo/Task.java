package com.example.capstone_6.pojo;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Task {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
	private LocalDate dueDate;
	private boolean complete;
	@ManyToOne
	private User user;
	
	public Task() {
		super();
	}

	public Task(Long id, String description, LocalDate dueDate, boolean complete) {
		super();
		this.id = id;
		this.description = description;
		this.dueDate = dueDate;
		this.complete = complete;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", dueDate=" + dueDate + ", complete=" + complete
				+ "]";
	}
	
	

}
