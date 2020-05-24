package com.github.celarcosa.employeemanagement.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.github.celarcosa.employeemanagement.exception.BadRequestException;

public final class RequestValidatorUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(RequestValidatorUtil.class);

	public static final <E> boolean validate(E obj) {
		LOG.trace("Validating request data");
		
		if (obj == null) {
			throw new BadRequestException("Request data is not provided");
		}
		
		Set<ConstraintViolation<E>> violations = Validation.buildDefaultValidatorFactory().getValidator().validate(obj);
		
		if (!CollectionUtils.isEmpty(violations)) {
			violations
				.stream()
				.findFirst()
				.ifPresent(violation -> {
					throw new BadRequestException(violation.getMessage());
				});
			
			return false;
		}
		
		
		return true;
	}
}
