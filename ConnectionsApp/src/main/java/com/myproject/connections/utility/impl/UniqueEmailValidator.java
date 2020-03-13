package com.myproject.connections.utility.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myproject.connections.serviceimpl.CustomerServiceImpl;
import com.myproject.connections.utility.UniqueEmail;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String>{
	 
	
	@Autowired
	CustomerServiceImpl customerService;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		return value!=null && !customerService.doesEmailIDExists(value);
	}

}
