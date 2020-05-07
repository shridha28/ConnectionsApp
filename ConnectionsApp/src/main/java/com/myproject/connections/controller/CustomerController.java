package com.myproject.connections.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.myproject.connections.entitybeans.CustomerEntity;
import com.myproject.connections.entitybeans.MessageBean;
import com.myproject.connections.models.CustomerDto;
import com.myproject.connections.serviceimpl.CustomerServiceImpl;
import com.myproject.connections.utility.CustomerResource;

/**
 * Class CustomerController. The contoller for customer api requests.
 * 
 * @author Shridha S Jalihal
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

	private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	CustomerServiceImpl customerService;


	@Autowired
	private CustomerResource customerResource;

	/*
	 * End Point to save Customer data in the database
	 * 
	 * @param CustomerEntity bean
	 * 
	 * @param bindingResults containing errors when validation fails
	 * 
	 * @return messageBean contains server errors if any after server validation
	 */
	@PostMapping("/api/signup")
	public MessageBean signUpCustomer(@RequestBody @Valid CustomerEntity customerEntity, BindingResult bindingResult) {
		logger.info("Validating customer details");
		if (bindingResult.hasErrors()) {
			logger.info("Server error: Invalid Customer details,returning server error in the front end");
			String message = bindingResult.getFieldError().getDefaultMessage();
			MessageBean bean = new MessageBean();
			bean.setError(message);
			return bean;

		}

		logger.info("Saving Customer Data in the database");
		logger.info("Calling CustomerServiceImpl to save Customer Data");
		customerService.saveCustomer(customerEntity);
		return new MessageBean();
	}

	/*
	 * End Point to update Customer data in the database
	 * 
	 * @param customerDetails model
	 * 
	 * @param bindingResults containing errors when validation fails
	 * 
	 * @return messageBean cont ains server errors if any after server validation
	 */
	@PatchMapping(value = "/api/updateProfile")
	public MessageBean updateCustomer(@RequestParam(value = "myFile", required = false) MultipartFile file,
			@RequestParam(value = "model") String model) throws JsonMappingException, JsonProcessingException {
				logger.info("Updating Customer Data in the database");
		logger.info("Calling CustomerServiceImpl to update Customer Data");
		customerService.updateUser(file,model);
		return new MessageBean();
	}

	/*
	 * End Point for Customer login.This is a dummy endpoint.Need to refactor later.
	 */
	@GetMapping("/api/login")
	public void login() {
		System.out.println("Logged in");
	}

	/*
	 * End Point to get Customer's data in the database based on Email ID(supports
	 * HATEOAS)
	 * 
	 * @pathvariable String emailId
	 * 
	 * @returns ResponseEntity<CustomerDto> contains Customer details and HATEOAS
	 * links
	 */
	@GetMapping("/api/getCustomer/{emailId}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable("emailId") String emailId) {
		logger.info("Getting a CustomerEntity Bean from repository ");
		CustomerEntity customerEntity = customerService.getCustomer(emailId);
		Optional<CustomerEntity> optionalCustomer = Optional.of(customerEntity);
		return optionalCustomer.map(customerResource::toModel).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());

	}

	// TBD--->Working/changed the @Id for EMail
	@GetMapping("/api/getCustomers/{emailId}")
	public CustomerEntity getCustomerDetail(@PathVariable("emailId") String emailId) {
		return customerService.getCustomer(emailId);
	}

	/* Note: using getters and setters only for mockito */

	public CustomerServiceImpl getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerServiceImpl customerService) {
		this.customerService = customerService;
	}

}