package com.myproject.connections.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.connections.beans.CustomerDetails;
import com.myproject.connections.beans.MessageBean;
import com.myproject.connections.beans.States;
import com.myproject.connections.serviceimpl.CustomerServiceImpl;
import com.myproject.connections.serviceimpl.StatesServiceImpl;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerService;
	
	@Autowired
	StatesServiceImpl stateService;


	
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
	
	@GetMapping("/getStatesData")
	public List<States> getStates(){
		System.out.println("Shridha");
		List<States> listOfStates = stateService.getAllStates();
		return listOfStates;
		
	}

	
	/* Note: using getters and setters only for mockito*/
	
	public CustomerServiceImpl getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerServiceImpl customerService) {
		this.customerService = customerService;
	}


}
