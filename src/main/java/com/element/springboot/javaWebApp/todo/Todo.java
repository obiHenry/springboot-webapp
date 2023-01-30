package com.element.springboot.javaWebApp.todo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

//Database (MySQL)
//static LIst of todos => Database (H2, MySQL)
@Entity
public class Todo {
	
	public Todo() {
		
	}
	
	@Id
	@GeneratedValue
	private int id;
	private String username;
	
	@Size(min=10, message="Enter at least 10 characters")
	private String description;
	private LocalDate date;
	private boolean done;

	public Todo(int id, String username, String description, LocalDate date, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.date = date;
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", date=" + date
				+ ", done=" + done + "]";
	}

}
