package com.myproject.connections.service;

import com.myproject.connections.entitybeans.CustomerDetails;

public interface CustomerService {
	
	public Long saveUser(CustomerDetails customer);
	public boolean doesEmailIDExists(String username);
	public void updateUser(CustomerDetails customer);
}
