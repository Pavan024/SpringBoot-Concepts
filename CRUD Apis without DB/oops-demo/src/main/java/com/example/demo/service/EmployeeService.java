package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.request.EmployeeRequest;
import com.example.demo.response.CreateEmployeeResponse;

@Service
public abstract class EmployeeService {

	public abstract ResponseEntity<CreateEmployeeResponse> saveEmployee(EmployeeRequest request);

	public abstract List<Employee> getEmployees();

	public abstract ResponseEntity<?> getProductById(Long id);

	public abstract ResponseEntity<?> deleteProduct(Long id);

	public abstract ResponseEntity<?> updateEmployee(EmployeeRequest request);
	
	public abstract ResponseEntity<?> updateEmployee(EmployeeRequest request, String emailId);

	

}
