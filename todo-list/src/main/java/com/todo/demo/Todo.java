package com.todo.demo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@jakarta.persistence.Entity
public class Todo {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String task;
    private boolean completed;
    
	public Todo(Long id, String task, boolean completed) {
		super();
		this.id = id;
		this.task = task;
		this.completed = completed;
	}
	public Todo() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

    
}
