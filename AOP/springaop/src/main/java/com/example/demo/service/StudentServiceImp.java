package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.College;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.repository.CollegeRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.request.StudentRequest;
import com.example.demo.response.StudentResponse;

import lombok.CustomLog;

@Service
public class StudentServiceImp implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CollegeRepository collegeRepository;

	@Override
	public StudentResponse createStudent(StudentRequest studentRequest) {
		// TODO Auto-generated method stub
		Student student = StudentMapper.getStudent(studentRequest, new Student());
		studentRepository.save(student);
		College college = StudentMapper.getCollege(studentRequest, new College(), student);
		collegeRepository.save(college);
		return StudentMapper.getStudentResponse(student);
	}
	@Override
	//@CustomAnnotation
	public Student getStudent(long id) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(id).orElse(null);
		return student;
	}
}
