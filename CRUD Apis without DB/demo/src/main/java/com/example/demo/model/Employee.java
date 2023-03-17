package com.example.demo.model;

public class Employee {
	private long empId;
	private String name;
	private String designation;
	private double salary;

	public Employee() {
		super();
	}

	public Employee(long empId, String name, String designation, double salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long l) {
		this.empId = l;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
