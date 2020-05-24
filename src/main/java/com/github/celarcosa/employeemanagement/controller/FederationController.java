package com.github.celarcosa.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.celarcosa.employeemanagement.exception.InvalidCredentialsException;
import com.github.celarcosa.employeemanagement.exception.UserNotFoundException;
import com.github.celarcosa.employeemanagement.model.UserAccountRequest;
import com.github.celarcosa.employeemanagement.processor.FederationProcessor;

@RestController
@RequestMapping("/v1/federation")
public class FederationController {
	
	@Autowired
	private FederationProcessor processor;

	@PostMapping("/login")
	public void login(@RequestBody UserAccountRequest request) 
			throws InvalidCredentialsException, UserNotFoundException {
		processor.process(request);
	}
}
