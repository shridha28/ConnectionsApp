package com.myproject.connections.service;

import com.myproject.connections.entitybeans.CustomerDetails;

public interface CustomerService {
	
	public Long saveUser(CustomerDetails user);
	public boolean doesEmailIDExists(String username);
}
