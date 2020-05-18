package com.myproject.connections.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.connections.controller.CustomerController;
import com.myproject.connections.entitybeans.MessageBean;
import com.myproject.connections.exceptions.EmailNotFoundException;
import com.myproject.connections.models.CustomerDto;
import com.myproject.connections.security.JWTUtil;
import com.myproject.connections.security.model.JWTResponse;
import com.myproject.connections.security.serviceimpl.CustomerSecurityServiceImpl;
import com.myproject.connections.security.serviceimpl.PasswordSecurityServiceImpl;

/*@author Shridha S Jalihal
 *LoginController:Controller class to handle login related API requests.
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {
	
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private CustomerSecurityServiceImpl customerSecurityServiceImpl;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	/*
	 * End Point for Customer login.This will create a jwt token and return the token 
	 * in the response
	 *  
	 * @param emailid of the Customer
	 * 
	 * @return ResponseEntity with JWT token
	 */
	@GetMapping("/api/login")
	public ResponseEntity<?> login(@RequestParam("emailId") String emailId) {
		
		
		final UserDetails userDetails = customerSecurityServiceImpl
				.loadUserByUsername(emailId);

		if(userDetails==null) {
			try {
				throw new EmailNotFoundException("EmailID :"+ emailId +"is not known" );
			} catch (EmailNotFoundException e) {
				logger.error("EmailID :"+ emailId +"is not known"); 
          }
		}
		
		final String token = jwtUtil.generateToken(userDetails);
		

		/*
		 * if (SecurityContextHolder.getContext().getAuthentication() != null) {
		 * Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 * Object principal = auth.getPrincipal(); CustomerSecurityServiceImpl
		 * userDetails1 = (CustomerSecurityServiceImpl) principal;
		 * System.out.println(userDetails1.loadUserByUsername(emailId).getUsername()); }
		 */
		return ResponseEntity.ok(new JWTResponse(token));
	}

}