package com.example.demo.client;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.request.UserRequest;

@FeignClient(url = "http://localhost:8082", name = "feign-second-service")
public interface UserRequestClient {
	
	@PostMapping("/getRequest")
	ResponseEntity<UserRequest>  sendRequest( @Valid @RequestBody UserRequest request);
	
	@PatchMapping("/request")
	ResponseEntity<UserRequest>  sendRequest1( @Valid @RequestBody UserRequest request);

}
