package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.client.UserRequestClient;
import com.example.demo.common.Constants;
import com.example.demo.entity.Address;
import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.UserRequest;
import com.example.demo.response.ApiResponse;
import com.example.demo.response.CreateUserResponse;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	private UserRequestClient client;
	
	@Autowired
	RestTemplate restTemplate;

	public CreateUserResponse saveUser(UserRequest request) {
		ResponseEntity<UserRequest> request1 = client.sendRequest(request);
		CreateUserResponse response = null;
		if (request1.getStatusCode() == HttpStatus.OK) {
			Optional<User> userOptional = userRepository.findByEmailId(request.getEmailId());
			if (userOptional.isPresent()) {
				throw new BadRequestException(Constants.USER_ALREADY_PRESENT);
			}

			User user = UserMapper.getUser(request, new User());
			userRepository.save(user);
			Address address = UserMapper.getAddress(request, new Address(), user);
			addressRepository.save(address);
			response = UserMapper.createUserResponse(user);
		}
		return response;
	}

	public User getUser(long id) {
		User user = userRepository.findById(id).orElse(null);
		if (user == null) {
			throw new BadRequestException(Constants.NO_VALUE_PRESENT);
		}
		return user;
	}

	public List<User> getUsers() {

		return userRepository.findAll();
	}

	public ApiResponse deleteUser(long id) {
		User user = userRepository.findById(id).orElse(null);
		if (user == null) {
			throw new BadRequestException(Constants.NO_VALUE_PRESENT);
		}
		return new ApiResponse(Constants.SUCCESS, Constants.DELETED_SUCCESSFULLY);
	}

	@Override
	public CreateUserResponse updateUser(long id, UserRequest request) {
//		ResponseEntity<UserRequest>  request1 = client.sendRequest1(request);
		String url = "http://localhost:8082/request";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<UserRequest> entity = new HttpEntity<>(request, headers);
		ResponseEntity<UserRequest> request1 = restTemplate.exchange(url, HttpMethod.PATCH, entity, UserRequest.class);
		CreateUserResponse response = null;
		if (request1.getStatusCode() == HttpStatus.OK) {
			User user = userRepository.findById(id).orElse(null);
			if (user == null) {
				throw new BadRequestException(Constants.NO_VALUE_PRESENT);
			}
			Address address = addressRepository.findByUserId(user);
			User user1 = UserMapper.getUser(request, user);
			userRepository.save(user1);
			Address address1 = UserMapper.getAddress(request, address, user);
			addressRepository.save(address1);
			response = UserMapper.updateUserResponse(user);
		}
		return response;
	}

}
