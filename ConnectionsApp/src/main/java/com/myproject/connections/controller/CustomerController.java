package com.myproject.connections.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.connections.entitybeans.Address;
import com.myproject.connections.entitybeans.CustomerDetails;
import com.myproject.connections.entitybeans.MessageBean;
import com.myproject.connections.models.CustomerModel;
import com.myproject.connections.serviceimpl.CustomerServiceImpl;
import com.myproject.connections.serviceimpl.StatesServiceImpl;

/**
 * @author acer
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {
	
	
	private static Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerServiceImpl customerService;
	
	@Autowired
	StatesServiceImpl stateService;


	
	@PostMapping("/api/signup")
	public MessageBean signUpCustomer(@RequestBody @Valid CustomerDetails customerDetails,BindingResult bindingResult){
		logger.info("Validating customer details");
		if(bindingResult.hasErrors()) {
		logger.info("Server error: Invalid Customer details,returning server error in the front end");
	    	String message = bindingResult.getFieldError().getDefaultMessage();
	    	MessageBean bean = new MessageBean();
	    	bean.setError(message);
	    	 return bean;
	    	 
	    }
		
		logger.info("Saving Customer Data in the database");
		 logger.info("Calling CustomerServiceImpl to save Customer Data");
	    customerService.saveUser(customerDetails);
	    return new MessageBean();
	}
	
	
	@PatchMapping("/api/updateProfile")
	public MessageBean updateCustomer(@RequestBody CustomerModel customerDetails,BindingResult bindingResult){
		logger.info("Validating customer details");
		if(bindingResult.hasErrors()) {
		logger.info("Server error: Invalid Customer details,returning server error in the front end");
	    	String message = bindingResult.getFieldError().getDefaultMessage();
	    	MessageBean bean = new MessageBean();
	    	bean.setError(message);
	    	 return bean;
	    
	    }
		
		logger.info("Saving Customer Data in the database");
		 logger.info("Calling CustomerServiceImpl to save Customer Data");
	//    customerService.saveUser(customerDetails);
	    return new MessageBean();
	}
	
	
	
	
	/* Note: using getters and setters only for mockito*/
	
	public CustomerServiceImpl getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerServiceImpl customerService) {
		this.customerService = customerService;
	}


}
