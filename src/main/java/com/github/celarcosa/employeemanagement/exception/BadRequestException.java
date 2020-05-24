package com.github.celarcosa.employeemanagement.exception;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 2368850398464917722L;

	private String message;
	
	public BadRequestException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
