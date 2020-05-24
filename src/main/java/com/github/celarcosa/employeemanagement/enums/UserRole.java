package com.github.celarcosa.employeemanagement.enums;

import java.util.Arrays;

public enum UserRole {
	ADMIN("admin"),
	USER("user");

	private String value;
	
	private UserRole(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	public static UserRole findByValue(String value) {
		return Arrays.asList(UserRole.values())
				.stream()
				.filter(userRole -> userRole.getValue().equals(value))
				.findFirst()
				.orElse(null);
	}
}
