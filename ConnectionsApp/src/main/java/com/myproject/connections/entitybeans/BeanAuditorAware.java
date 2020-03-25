package com.myproject.connections.entitybeans;

/**
 * Author: Sahithi
 * Implementing Auditor to get the principal user(Logged in user)
 */


import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class BeanAuditorAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.ofNullable("Current User").filter(s->!s.isEmpty());
	}

}
