package com.example.demo.response;

public class CreateEmployeeResponse {

	private String status;
	private long id;
	private String firstName;
	private String message;

	public CreateEmployeeResponse(String status, long id, String firstName, String message) {
		super();
		this.status = status;
		this.id = id;
		this.firstName = firstName;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
