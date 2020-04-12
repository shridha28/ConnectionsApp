package com.myproject.connections.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.myproject.connections.entitybeans.CustomerEntity;
import com.myproject.connections.repository.CustDetailsRepository;
import com.myproject.connections.service.CustomerService;

/**
 * @author Shridha S Jalihal
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	/**
	 * 
	 */
	private static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;


	@Autowired
	private CustDetailsRepository custDetailsRepository;

	/*
	 * service method to save Customer data in the database
	 * 
	 * @param customerDetails sql bean
	 */
	public Long saveCustomer(CustomerEntity customerEntity) {
		logger.debug("Encrypted password using password Encoder");
		customerEntity.setPassword(bCryptPasswordEncoder.encode(customerEntity.getPassword()));
		logger.debug("Saving data with emailId:" + customerEntity.getEmailid());
		logger.debug("Calling CustDetailsRepository to save Customers Data");
		custDetailsRepository.save(customerEntity);
		logger.debug("Data Successfully saved");
		return new Long(100);
	}

	/*
	 * service method to update Customer data in the database
	 * 
	 * @param customerDetails sql bean
	 */
	public void updateUser(CustomerEntity customerEntity) {
		logger.debug("Encrypted password using password Encoder");

		logger.debug("Updating data with emailId:" + customerEntity.getEmailid());
		logger.debug("Calling CustDetailsRepository to save Customers Data");
		CustomerEntity customerEntityUpdate = custDetailsRepository.findByEmailid(customerEntity.getEmailid());

		customerEntityUpdate.setAddressEntity(customerEntity.getAddressEntity());
		customerEntityUpdate.setName(customerEntity.getName());
		custDetailsRepository.save(customerEntityUpdate);
		logger.debug("Data Successfully saved");

	}

	/*
	 * service method to get check if an Email Id exists in the database and return
	 * the associated
	 * 
	 * @param String emailId
	 * 
	 * @return boolean value that indicates if an emailId exists
	 */
	public boolean doesEmailExist(String emailId) {
		logger.info("Checking if the emailID already exists");
		logger.debug("Check if the email ID already exists using UniqeEmailCustomValidator:" + emailId);
		boolean userInDb = true;
		if (findByEmailId(emailId)!=null)
			return userInDb;
		else
			return false;
	}
	
	/*Method call to customerRepository to get the CustomerDetails
	 * @param emailid
	 * @return CustomerDetails
	 */
	public CustomerEntity findByEmailId(String emailid){
		return custDetailsRepository.findByEmailid(emailid);
	}

	/*
	 * service method to get Customer data from the database
	 * 
	 * @param String emailId
	 * 
	 * @return CustomerEntity Bean
	 */
	public CustomerEntity getCustomer(String emailId) {
		logger.debug("Fetching a Customer with Unique EmailId");
		CustomerEntity customerEntity = custDetailsRepository.findByEmailid(emailId);
		return customerEntity;

	}

	/*
	 * service method to update Customer's new password
	 * 
	 * @param CustomerEntity Bean
	 * 
	 */
	public void updatePassword(CustomerEntity customerEntity) {
		logger.debug("Saving customerEntity bean with new password");
		custDetailsRepository.save(customerEntity);

	}

}
