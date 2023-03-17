package com.example.demo.entity;

import java.time.LocalDateTime;

public class BaseEntity {

	private Long id;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	public BaseEntity(LocalDateTime updatedAt) {
		super();
	
		this.updatedAt = updatedAt;
	}

	public BaseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
