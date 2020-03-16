package com.myproject.connections.serviceimpl;

import java.util.Calendar;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.myproject.connections.beans.CustomerDetails;
import com.myproject.connections.repository.CustDetailsRepository;
import com.myproject.connections.service.CustomerService;

/**
 * @author acer
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService{
	
	/**
	 * 
	 */
	private static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class); 
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	
	@Autowired
	private CustDetailsRepository custDetailsRepository;
	
	
	
	public Long saveUser(CustomerDetails customerDetails) {
		logger.debug("Encrypted password using password Encoder");
		customerDetails.setPassword(bCryptPasswordEncoder.encode(customerDetails.getPassword()));
		customerDetails.setCreation_date(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		logger.debug("Saving data with emailId:"+customerDetails.getEmailid());
		logger.debug("Calling CustDetailsRepository to save Customers Data");
		custDetailsRepository.save(customerDetails);
		logger.debug("Data Successfully saved");
		return customerDetails.getId();
	}
	
	
	
	
		public boolean doesEmailIDExists(String username){
			logger.info("Checking if the emailID already exists");
			logger.debug("Check if the email ID already exists using UniqeEmailCustomValidator:"+username);	
			boolean userInDb = true;
			if (custDetailsRepository.findByEmailid(username)!=null)
				return userInDb;
			else 
				return false;
		}
}
