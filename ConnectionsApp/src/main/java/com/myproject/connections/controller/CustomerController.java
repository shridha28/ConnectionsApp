package com.myproject.connections.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.connections.beans.CustomerDetails;
import com.myproject.connections.beans.MessageBean;
import com.myproject.connections.serviceimpl.CustomerServiceImpl;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerService;


	
	@PostMapping("/api/signup")
	public MessageBean signUpCustomer(@RequestBody @Valid CustomerDetails customerDetails,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
	    	System.out.println(bindingResult.getFieldError().getDefaultMessage());
	    	String message = bindingResult.getFieldError().getDefaultMessage();
	    	MessageBean bean = new MessageBean();
	    	bean.setError(message);
	    	 return bean;
	    
	    }
	    customerService.saveUser(customerDetails);
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
