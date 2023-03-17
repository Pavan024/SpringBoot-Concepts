package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;

@RestController
public class EmployeeController {
	
	@GetMapping("/employee")
	public Employee getEmployee() {
		Employee emp = new Employee();
		emp.setDesignation("Java Developer");
		emp.setEmpId(1l);
		emp.setName("Pavan Kumar");
		emp.setSalary(10000.00);
		return emp;
	}

}
