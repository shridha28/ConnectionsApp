package com.myproject.connections.service;

import com.myproject.connections.entitybeans.CustomerEntity;

public interface CustomerService {
	
	public Long saveCustomer(CustomerEntity customer);
	public boolean doesEmailExist(String emailId);
	public void updateUser(CustomerEntity customer);
}
