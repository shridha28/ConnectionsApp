package com.myproject.connections.entitybeans;

/**
 * Author: Sahithi
 * Implementing Auditor to get the principal user(Logged in user)
 */


import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.myproject.connections.security.serviceimpl.CustomerSecurityServiceImpl;

public class BeanAuditorAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		/*
		 * if (SecurityContextHolder.getContext().getAuthentication() != null) {
		 * Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 * Object principal = auth.getPrincipal(); CustomerSecurityServiceImpl
		 * userDetails = (CustomerSecurityServiceImpl) principal;
		 * 
		 * String user = userDetails.getCustomerEntity().getEmailid()+
		 * userDetails.getCustomerEntity().getId();
		 * 
		 * return Optional.of(user); } else
		 */
			return Optional.of("Unknown");
	}

}
