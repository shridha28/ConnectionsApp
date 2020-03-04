package com.myproject.connections.serviceimpl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.myproject.connections.beans.CustomerDetails;
import com.myproject.connections.repository.CustDetailsRepository;
import com.myproject.connections.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	
	@Autowired
	private CustDetailsRepository custDetailsRepository;
	
	
	
	public CustomerDetails saveUser(CustomerDetails customerDetails) {
		customerDetails.setPassword(bCryptPasswordEncoder.encode(customerDetails.getPassword()));
		customerDetails.setCreation_date(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		
	    return custDetailsRepository.save(customerDetails);
	  
	}

}
