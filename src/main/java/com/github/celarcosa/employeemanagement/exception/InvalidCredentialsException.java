package com.github.celarcosa.employeemanagement.exception;

public class InvalidCredentialsException extends Exception {

	private static final long serialVersionUID = -2634307744194513502L;

	private String message;
	
	public InvalidCredentialsException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
