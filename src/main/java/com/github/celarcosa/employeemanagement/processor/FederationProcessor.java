package com.github.celarcosa.employeemanagement.processor;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.github.celarcosa.employeemanagement.entity.UserAccount;
import com.github.celarcosa.employeemanagement.exception.InvalidCredentialsException;
import com.github.celarcosa.employeemanagement.exception.UserNotFoundException;
import com.github.celarcosa.employeemanagement.model.UserAccountRequest;
import com.github.celarcosa.employeemanagement.service.UserAccountService;
import com.github.celarcosa.employeemanagement.util.GrantedAuthorityUtil;

@Component
public class FederationProcessor {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FederationProcessor.class);
	
	@Autowired
	private UserAccountService userAccountService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public void process(UserAccountRequest request) 
			throws InvalidCredentialsException, UserNotFoundException {

		LOGGER.info("Started processing federation request");

		Optional<UserAccount> userAccount = Optional.ofNullable(userAccountService.getAccountByUsername(request.getUsername()));
		
		if (userAccount.isPresent()) {
			if (passwordEncoder.matches(request.getPassword(), userAccount.get().getPassword())) {
				UserAccount account = userAccount.get();
	
				List<SimpleGrantedAuthority> authorities = GrantedAuthorityUtil.getGrantedAuthorities(account.getRoles());
				SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword(), authorities));
			} else {
				throw new InvalidCredentialsException("Invalid password");
			}
		} else {
			throw new UserNotFoundException("No user account was found");
		}
	}

}
