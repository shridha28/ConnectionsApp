package com.myproject.connections.controller;

import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.connections.entitybeans.CustomerEntity;
import com.myproject.connections.entitybeans.MessageBean;
import com.myproject.connections.models.CustomerDto;
import com.myproject.connections.service.EmailService;
import com.myproject.connections.serviceimpl.CustomerServiceImpl;

/*@author Shreya S Jalihal
 * PasswordController:Controller class to handle forgot password/password change api requests.
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PasswordController {

	@Autowired
	private CustomerServiceImpl customerService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private static final Logger logger = LoggerFactory.getLogger(PasswordController.class);

	/*
	 * End Point to generate and save reset code for changing password and send an
	 * email to the customer with the reset code
	 * 
	 * @param String emailId
	 * 
	 * @return messageBean contains server errors if any after server validation
	 */
	@PostMapping("/forgotPassword")
	public MessageBean processForgotPasswordForm(@RequestBody String emailId) {
		logger.debug("Retrieving CustomerEntity Bean from the database associated with emailId ");
		MessageBean messageBean = new MessageBean();
		CustomerEntity customerEntity = customerService.getCustomer(emailId);
		Optional<CustomerEntity> optionalCustomer = Optional.ofNullable(customerEntity);
		logger.debug("Validating if a CustomerEntity associated to the emailId exists");
		if (!optionalCustomer.isPresent()) {
			String message = "Oops! We didn't find an account for that e-mail address";
			messageBean.setError(message);
			return messageBean;
		} else {
			// Generate random 6 character string Pin for reset password
			customerEntity.setCode(RandomStringUtils.randomNumeric(6).toString());
			logger.debug("Saving the customer Entity with the code generated" + " " + customerEntity);
			// save the code to the Database
			customerService.saveCustomer(customerEntity);

			// Email Message
			logger.debug("Sending an email with a 6-digit code to reset password");
			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
			passwordResetEmail.setFrom("shreya.jalihal@gmail.com");
			passwordResetEmail.setTo(customerEntity.getEmailid());
			passwordResetEmail.setSubject("Password Reset Request");
			passwordResetEmail.setText("Hi" + " " + customerEntity.getName() + "\n"
					+ "We received a request to reset the password on your Account." + "\n" + customerEntity.getCode()
					+ "\n" + "Enter this code to complete the reset." + "\n"
					+ "Thanks for helping us keep your account secure." + "\n" + "The ConnectionsApp Team");

			emailService.sendEmail(passwordResetEmail);
			logger.info("Email with a reset code sent");
		}
		return messageBean;
	}

	/*
	 * End Point to verify the reset code for password change
	 * 
	 * @param String code
	 * 
	 * @param String emailId
	 * 
	 * @return messageBean contains server errors if any after server validation
	 */
	@GetMapping("/resetform")
	public MessageBean displayResetPasswordPage(@RequestParam("code") String code,
			@RequestParam("emailId") String emailId) {
		logger.debug("Retrieving CustomerEntity Bean from the database associated with emailId ");
		CustomerEntity customerEntity = customerService.getCustomer(emailId);
		MessageBean messageBean = new MessageBean();
		// If customer is present check if the code matches
		logger.debug(
				"verifying if the customerEntity Bean exists and the param code value matches the code saved for the customer in the database");
		if (customerEntity != null && code.equals(customerEntity.getCode()))
			return messageBean;
		else { // Code not found in DB
			logger.error("Code verfication failed");
			messageBean.setError("Hmm, that's not the right code.");
		}
		return messageBean;
	}

	/*
	 * End Point to save the Customer Entity with new password
	 * 
	 * @param CustomerDto customerDto
	 * 
	 * @return messageBean contains server errors if any after server validation
	 */
	@PostMapping("/reset")
	public MessageBean setNewPassword(@RequestBody CustomerDto customerDto, BindingResult bindingResult) {
		logger.info("Validating customer details");
		MessageBean messageBean = new MessageBean();
		if (bindingResult.hasErrors()) {
			logger.debug("Server error: Invalid Customer details,returning server error in the front end");
			String message = bindingResult.getFieldError().getDefaultMessage();
			messageBean.setError(message);
			return messageBean;
		}
		logger.debug("Retrieving CustomerEntity Bean from the database associated with emailId");
		// Find the user associated with the emailId
		CustomerEntity customerEntity = customerService.getCustomer(customerDto.getEmailid());

		// This should always be non-null but we check just in case
		logger.debug(
				"verifying if the customerEntity Bean exists and the param code matches the code saved for the customer in the database");
		if (customerEntity != null && customerDto.getCode().equals(customerEntity.getCode())) {

			// Set new password
			customerEntity.setPassword(bCryptPasswordEncoder.encode(customerDto.getPassword()));

			// Set the code to null so that it can be used again
			customerEntity.setCode(null);

			// Save customer
			logger.debug("Saving customer in the database with  a new password set");
			customerService.saveCustomer(customerEntity);

		} else {
			logger.error("Error occurred while trying to save the customer Entity details with new password");
			messageBean.setError("We experienced an error while saving your new password");
		}
		return messageBean;
	}
}