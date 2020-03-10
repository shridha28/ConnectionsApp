package com.myproject.connections.service;

import com.myproject.connections.beans.CustomerDetails;

public interface CustomerService {
	
	
	
	public Long saveUser(CustomerDetails user);

	public boolean doesEmailIDExists(String username);
}
