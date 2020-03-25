package com.myproject.connections.entitybeans;

/**
 * Author: Sahithi
 * Implementing Auditor to get the principal user(Logged in user)
 */


import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class SpringAuditorAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO Auto-generated method stub
		return Optional.ofNullable("Current User").filter(s->!s.isEmpty());
	}

}
