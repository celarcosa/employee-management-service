package com.github.celarcosa.employeemanagement.exception;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = -2993180569281288388L;

	private String message;
	
	public UserNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
