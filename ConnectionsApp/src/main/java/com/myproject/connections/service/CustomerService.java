package com.myproject.connections.service;

import java.util.Optional;

import com.myproject.connections.entitybeans.CustomerEntity;

public interface CustomerService {
	
	public Long saveCustomer(CustomerEntity customer);
	public boolean doesEmailExist(String emailId);
	public void updateUser(CustomerEntity customer);
	public void updatePassword(CustomerEntity customerEntity);
	
}
