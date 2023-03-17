package com.example.demo.repositroy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public class EmployeeRepositroy {

	List<Employee> list = new ArrayList<Employee>();

	public List<Employee> getAllEmployees() {
		return list;
	}

	public Employee save(Employee e) {
		Employee employee = new Employee();
		employee.setId(e.getId());
		employee.setCreatedAt(e.getCreatedAt());
		employee.setUpdatedAt(e.getUpdatedAt());
		employee.setFirstName(e.getFirstName());
		employee.setLastName(e.getLastName());
		employee.setPhoneNo(e.getPhoneNo());
		employee.setEmailId(e.getEmailId());
		list.add(employee);
		return employee;
	}

	public Employee findById(Long id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == (id)) {
				return list.get(i);
			}
		}
		return null;
	}

	public Employee findByEmailId(String emailId) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEmailId().equals(emailId)) {
				return list.get(i);
			}
		}
		return null;
	}

	public String delete(Long id) {
		list.removeIf(x -> x.getId() == (id));
		return null;
	}

	public Employee update(Employee employee) {
		Employee employee1 = new Employee(employee.getFirstName(), employee.getLastName(), employee.getPhoneNo(),
				employee.getEmailId(), employee.getUpdatedAt());
		return employee1;
	}

}
