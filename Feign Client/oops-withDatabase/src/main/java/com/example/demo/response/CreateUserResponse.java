package com.example.demo.response;

import com.example.demo.entity.Admin;
import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CreateUserResponse {

	private String status;
	private User result;
	private Admin admin;
	private String message;

	public CreateUserResponse() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getResult() {
		return result;
	}

	public void setResult(User result) {
		this.result = result;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}
