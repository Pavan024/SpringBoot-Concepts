package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.request.StudentRequest;
import com.example.demo.response.StudentResponse;

@Service
public interface StudentService {

	public StudentResponse createStudent(StudentRequest studentRequest);
  
	public Student getStudent(long id);

}
