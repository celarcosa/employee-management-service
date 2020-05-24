package com.github.celarcosa.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.celarcosa.employeemanagement.entity.UserAccount;
import com.github.celarcosa.employeemanagement.repositories.UserAccountRepository;

@Service
public class UserAccountServiceImpl implements UserAccountService {
	
	@Autowired
	private UserAccountRepository repository;

	@Override
	public UserAccount getAccountByUsername(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public UserAccount saveUserAccount(UserAccount userAccount) {
		return repository.save(userAccount);
	}
}
