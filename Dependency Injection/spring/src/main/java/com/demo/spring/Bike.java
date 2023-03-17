package com.demo.spring;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vechile {
	
	public void drive() {
		System.out.println("New bike");
	}

}
