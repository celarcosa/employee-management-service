package com.github.celarcosa.employeemanagement.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.github.celarcosa.employeemanagement.enums.UserRole;

public final class GrantedAuthorityUtil {
	
	private static final String READ_PRIVILEGE = "READ_PRIVILEGE";
	private static final String WRITE_PRIVILEGE = "WRITE_PRIVILEGE";
	private static final String ROLE_DELIMITER = ",";

	public static final List<SimpleGrantedAuthority> getGrantedAuthorities(String roles) {
		List<SimpleGrantedAuthority> grantedAuthorities = Arrays.asList(new SimpleGrantedAuthority(READ_PRIVILEGE));

		boolean isAdmin = false;
		if (roles != null) {
			isAdmin = Arrays.asList(roles.split(ROLE_DELIMITER))
					.stream()
					.anyMatch(role -> UserRole.ADMIN.getValue().equals(role));
			
			if (isAdmin) {
				grantedAuthorities.add(new SimpleGrantedAuthority(WRITE_PRIVILEGE));
			}
		}
		
		return grantedAuthorities;
	}
}
