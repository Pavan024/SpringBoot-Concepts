package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.request.StudentRequest;
import com.example.demo.response.StudentResponse;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;

	@PostMapping(value = "/createStudent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentRequest s) {
		StudentResponse createStudent = studentService.createStudent(s);
		return ResponseEntity.status(HttpStatus.OK).body(createStudent);

	}
	
	@GetMapping(value = "/student/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") long id) {
		Student student = studentService.getStudent(id);
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}

}
