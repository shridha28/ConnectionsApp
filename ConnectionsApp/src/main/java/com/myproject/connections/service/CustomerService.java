package com.myproject.connections.service;

import com.myproject.connections.entitybeans.CustomerEntity;
/*@author Shridha S Jalihal
 *Customer Service interface */
public interface CustomerService {
	
	public Long saveCustomer(CustomerEntity customer);
	public boolean doesEmailExist(String emailId);
	public void updateCustomer(CustomerEntity customerEntity);
	
}
