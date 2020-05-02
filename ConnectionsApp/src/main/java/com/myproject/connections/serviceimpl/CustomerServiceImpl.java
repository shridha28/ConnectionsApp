package com.myproject.connections.serviceimpl;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.connections.entitybeans.CustomerEntity;
import com.myproject.connections.entitybeans.Role;
import com.myproject.connections.exceptions.EmailNotFoundException;
import com.myproject.connections.models.CustomerDto;
import com.myproject.connections.models.ImageModel;
import com.myproject.connections.repository.CustDetailsRepository;
import com.myproject.connections.service.CustomerService;

/**
 * Service class implementation for Customer
 * 
 * @author Shridha S Jalihal
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	private static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private CustDetailsRepository custDetailsRepository;

	/*
	 * service method to save Customer data in the database
	 * 
	 * @param CustomerEntity bean
	 * 
	 * return long
	 */
	public CustomerEntity saveCustomer(CustomerEntity customerEntity) {
		logger.debug("Encrypted password using password Encoder");
		customerEntity.setPassword(bCryptPasswordEncoder.encode(customerEntity.getPassword()));
		logger.debug("Saving data with emailId:" + customerEntity.getEmailid());
		Role role = new Role();
		role.setRole_id(1001);
		role.setRolename("admin");
		customerEntity.getRoles().add(role);
		logger.debug("Calling CustDetailsRepository to save Customers Data");
		custDetailsRepository.save(customerEntity);
		logger.debug("Data Successfully saved");
		return customerEntity;
	}

	/*
	 * service method to update Customer data in the database
	 * 
	 * @param CustomerEntity bean
	 */
	public void updateUser(MultipartFile file, String model) {
		logger.info("Mapping model to CustomerDto Object using Object Mapper");
		ObjectMapper mapper = new ObjectMapper();
		ModelMapper modelMapper = new ModelMapper();
		CustomerEntity customerEntity = null;
		try {
			CustomerDto customerDto = mapper.readValue(model, CustomerDto.class);
			customerEntity = new CustomerEntity();
			customerEntity = modelMapper.map(customerDto, CustomerEntity.class);
			if (file != null) {
				ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
				customerEntity.setImageModel(img);
			}
			if (customerDto.getTechnologies() != null)
				customerEntity.setTechnologies(customerDto.getTechnologies());
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.debug("Updating data with emailId");
		logger.debug("Calling CustDetailsRepository to save Customers Data");
		CustomerEntity customerEntityUpdate = custDetailsRepository.findByEmailid(customerEntity.getEmailid());
		customerEntityUpdate.setImageModel(customerEntity.getImageModel());
		if (customerEntity.getLinkedInUrl() != null)
			customerEntityUpdate.setLinkedInUrl(customerEntity.getLinkedInUrl());
		if (customerEntity.getTechnologies() != null)
			customerEntityUpdate.setTechnologies(customerEntity.getTechnologies());
		custDetailsRepository.save(customerEntityUpdate);

		logger.debug("Data Successfully saved");

	}

	/*
	 * service method to get check if an Email Id exists in the database and return
	 * boolean value
	 * 
	 * @param String emailId
	 * 
	 * @return boolean value that indicates if an emailId exists
	 */
	public boolean doesEmailExist(String emailId) {
		logger.info("Checking if the emailID already exists");
		logger.debug("Check if the email ID already exists using UniqeEmailCustomValidator:" + emailId);
		boolean userInDb = true;
		if (getCustomer(emailId) != null)
			return userInDb;
		else
			return false;
	}

	/*
	 * service method to get Customer data from the database
	 * 
	 * @param String emailId
	 * 
	 * @return CustomerEntity bean
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
	public void updateCustomer(CustomerEntity customerEntity) {
		logger.debug("Saving customerEntity bean with new password");
		custDetailsRepository.save(customerEntity);

	}

}
