package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.request.EmployeeRequest;
import com.example.demo.response.CreateEmployeeResponse;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	public EmployeeService employeeService;

	@PostMapping(value = "/addEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreateEmployeeResponse> addEmployee(@RequestBody EmployeeRequest request) {
		return employeeService.saveEmployee(request);
	}

	@GetMapping(value = "/getEmployees")
	public List<Employee> getAllEmployees() {
		return employeeService.getEmployees();

	}

	@GetMapping(value = "employee/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable("id") Long id) {
		return employeeService.getProductById(id);
	}

	@DeleteMapping(value = "employee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
		return employeeService.deleteProduct(id);
	}
	
	@PutMapping(value = "updateEmployee")
	public ResponseEntity<?> updateEmployee(@RequestBody EmployeeRequest request) {
		return employeeService.updateEmployee(request);
	}
	
	@PatchMapping(value = "updateEmployee/{emailId}")
	public ResponseEntity<?> updateEmployeeField(@PathVariable("emailId") String emailId, @RequestBody EmployeeRequest request) {
		return employeeService.updateEmployee(request, emailId);
	}

}
