package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.College;


public interface CollegeRepository extends  MongoRepository<College, String>{

}
