package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.common.Constants;
import com.example.demo.entity.Employee;
import com.example.demo.repositroy.EmployeeRepositroy;
import com.example.demo.request.EmployeeRequest;
import com.example.demo.response.ApiResponse;
import com.example.demo.response.CreateEmployeeResponse;

@Service
public class EmployeeServiceImpl extends EmployeeService {

	@Autowired
	private EmployeeRepositroy employeeRepositroy;

	public ResponseEntity<CreateEmployeeResponse> saveEmployee(EmployeeRequest request) {
		Employee employee = new Employee();
		employee.setId(employeeRepositroy.getAllEmployees().size() + 1L);
		employee.setCreatedAt(LocalDateTime.now());
		employee.setUpdatedAt(LocalDateTime.now());
		employee.setFirstName(request.getFirstName());
		employee.setLastName(request.getLastName());
		employee.setPhoneNo(request.getPhoneNo());
		employee.setEmailId(request.getEmailId());
		employeeRepositroy.save(employee);
		return ResponseEntity.status(HttpStatus.OK).body(new CreateEmployeeResponse(Constants.SUCCESS, employee.getId(),
				employee.getFirstName(), Constants.EMPLOYEE_ADDED_SUCCESSFULLY));
	}

	public List<Employee> getEmployees() {
		return employeeRepositroy.getAllEmployees();
	}

	public ResponseEntity<?> getProductById(Long id) {
		Employee employee = employeeRepositroy.findById(id);
		if (employee == null) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponse(Constants.FAILED, Constants.NO_VALUE_PRESENT));

		}
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}

	public ResponseEntity<?> deleteProduct(Long id) {
		Employee employee = employeeRepositroy.findById(id);
		if (employee == null) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponse(Constants.FAILED, Constants.NO_VALUE_PRESENT));

		}
		employeeRepositroy.delete(employee.getId());
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponse(Constants.SUCCESS, Constants.DELETED_SUCCESSFULLY));
	}

	public ResponseEntity<?> updateEmployee(EmployeeRequest request) {
		Employee employee = employeeRepositroy.findByEmailId(request.getEmailId());
		if (employee == null) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponse(Constants.FAILED, Constants.NO_VALUE_PRESENT));

		}
		employee.setUpdatedAt(LocalDateTime.now());
		employee.setFirstName(request.getFirstName());
		employee.setLastName(request.getLastName());
		employee.setEmailId(request.getEmailId());
		employee.setPhoneNo(request.getPhoneNo());
		employeeRepositroy.update(employee);

		return ResponseEntity.status(HttpStatus.OK).body(new CreateEmployeeResponse(Constants.SUCCESS, employee.getId(),
				employee.getFirstName(), Constants.EMPLOYEE_UPDATED_SUCCESSFULLY));

	}

	@Override
	public ResponseEntity<?> updateEmployee(EmployeeRequest request, String emailId) {
		Employee employee = employeeRepositroy.findByEmailId(emailId);
		if (employee == null) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponse(Constants.FAILED, Constants.NO_VALUE_PRESENT));

		}
		
        if (request.getFirstName() != null) {
        	employee.setFirstName(request.getFirstName());
        }
        if (request.getLastName() != null) {
        	employee.setLastName(request.getLastName());
        }
    	if (request.getPhoneNo() != null) {
			employee.setPhoneNo(request.getPhoneNo());
        }
    	
    	if (request.getPhoneNo() != null) {
    		return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponse(Constants.FAILED, Constants.CAN_NOT_UPDATE_EMAILID));
        }
		employeeRepositroy.update(employee);

		return ResponseEntity.status(HttpStatus.OK).body(new CreateEmployeeResponse(Constants.SUCCESS, employee.getId(),
				employee.getFirstName(), Constants.EMPLOYEE_UPDATED_SUCCESSFULLY));
	}
	
	

}
