package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.request.UserRequest;
import com.example.demo.response.ApiResponse;
import com.example.demo.response.CreateUserResponse;

public interface UserService {

	public CreateUserResponse saveUser(UserRequest request);
	
	public User getUser(long id);
	
	public List<User> getUsers();
	
	public ApiResponse deleteUser(long id);

	public CreateUserResponse updateUser(long id, UserRequest request);
	

}
