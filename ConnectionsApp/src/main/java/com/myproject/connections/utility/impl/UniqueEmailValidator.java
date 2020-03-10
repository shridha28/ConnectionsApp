package com.myproject.connections.utility.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myproject.connections.serviceimpl.CustomerServiceImpl;
import com.myproject.connections.utility.UniqueEmail;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String>{
	
	private String message;
	 
	
	@Autowired
	CustomerServiceImpl customerService;
	
	
	//public UniqueEmailValidator() {}
	
	/*
	 * public UniqueEmailValidator(CustomerServiceImpl userRepository) {
	 * this.customerService = userRepository; }
	 */
	 @Override
	 public void initialize(UniqueEmail constraintAnnotation) {
	     message = constraintAnnotation.message();
	 }
	 
	 
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		return value!=null && !customerService.doesEmailIDExists(value);
	}

}
