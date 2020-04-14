package com.myproject.connections.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.myproject.connections.entitybeans.CustomerEntity;
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
		//CustomerEntity cust = new CustomerEntity(null,"abc.hu",null, null,null, "ddd");
	//	System.out.println(cust.getId());
	//	when(serviceImpl.saveUser(cust)).thenRetur());
	//	Assertions.assertNotNull(cust.getId());
		
		
		
	}

}
