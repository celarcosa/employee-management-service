package com.github.celarcosa.employeemanagement.service;

import com.github.celarcosa.employeemanagement.entity.UserAccount;

public interface UserAccountService {
	
	UserAccount getAccountByUsername(String username);
	
	UserAccount saveUserAccount(UserAccount userAccount);
}
