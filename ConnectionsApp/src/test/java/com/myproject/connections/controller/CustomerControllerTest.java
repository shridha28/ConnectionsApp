package com.myproject.connections.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.myproject.connections.beans.CustomerDetails;
import com.myproject.connections.repository.CustDetailsRepository;
import com.myproject.connections.serviceimpl.CustomerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
class CustomerControllerTest {

	@InjectMocks
	CustomerServiceImpl serviceImpl;
	
	
	@Mock
	CustDetailsRepository repo;
	
	
	@Mock
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@InjectMocks
	CustomerController controller;
	
	@BeforeEach 
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void create_Customer_Shud_CreateAUser() {
		controller.setCustomerService(serviceImpl);
		CustomerDetails cust = new CustomerDetails(null,"abc.hu",null, null,null, "ddd");
	//	System.out.println(cust.getId());
		when(serviceImpl.saveUser(cust)).thenReturn(cust.getId());
	//	Assertions.assertNotNull(cust.getId());
		
		
		
	}

}
