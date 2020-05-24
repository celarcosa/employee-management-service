package com.github.celarcosa.employeemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.celarcosa.employeemanagement.entity.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

	UserAccount findByUsername(String username);
}
