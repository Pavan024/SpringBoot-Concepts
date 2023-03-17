package com.example.demo.entity;

import java.time.LocalDateTime;

public class Employee extends BaseEntity {

	private String firstName;

	private String lastName;

	private String phoneNo;

	private String emailId;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String phoneNo, String emailId, LocalDateTime updatedAt) {
		super(updatedAt);
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	

}
