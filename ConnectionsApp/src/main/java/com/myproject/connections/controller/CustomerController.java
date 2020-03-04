package com.myproject.connections.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.connections.beans.CustomerDetails;
import com.myproject.connections.serviceimpl.CustomerServiceImpl;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerService;

	

	@GetMapping("/api/signup/demo")
	public void message(){
	    System.out.println("fff");
	}
	
	@PostMapping("/api/signup")
	public void signUpCustomer(@RequestBody CustomerDetails customerDetails){
	    customerService.saveUser(customerDetails);
	}


}
