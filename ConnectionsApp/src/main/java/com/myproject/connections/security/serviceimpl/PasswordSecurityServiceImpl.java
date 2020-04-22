package com.myproject.connections.security.serviceimpl;

import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.myproject.connections.entitybeans.CustomerEntity;
import com.myproject.connections.entitybeans.MessageBean;
import com.myproject.connections.exceptions.EmailNotFoundException;
import com.myproject.connections.models.CustomerDto;
import com.myproject.connections.service.EmailService;
import com.myproject.connections.service.PasswordSecurityService;
import com.myproject.connections.serviceimpl.CustomerServiceImpl;

/**
 * @author Shreya S Jalihal Service class PasswordSecurityServiceImpl for
 *         Password change related functionality.
 */
@Service
public class PasswordSecurityServiceImpl implements PasswordSecurityService {

	@Autowired
	private CustomerServiceImpl customerService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private static final Logger logger = LoggerFactory.getLogger(PasswordSecurityServiceImpl.class);

	/*
	 * Method to send an email with ResetCode for password change
	 * 
	 * @param emailid.
	 * 
	 * return MessageBean bean
	 */
	public MessageBean sendEmailWithResetCode(String emailId,MessageBean messageBean)throws EmailNotFoundException  {
		logger.debug("Retrieving CustomerEntity Bean from the database associated with emailId ");
		CustomerEntity customerEntity = customerService.getCustomer(emailId);
		Optional<CustomerEntity> optionalCustomer = Optional.ofNullable(customerEntity);
		logger.debug("Validating if a CustomerEntity associated to the emailId exists");
		
			//isPresent() returns true if the Optional contains a non-null value
			if (!optionalCustomer.isPresent()) {
				String message = "Oops! We didn't find an account for that e-mail address";
				messageBean.setError(message);
				throw new EmailNotFoundException("Email not found in the Database");
			}
			 else {
				// Generate random 6 character string code for reset password
				customerEntity.setCode(RandomStringUtils.randomNumeric(6).toString());
				logger.debug("Saving the customer Entity with the code generated" + " " + customerEntity);
				// save the code to the Database
				customerService.updateCustomer(customerEntity);

				// Email Message
				logger.debug("Sending an email with a 6-digit code to reset password");
				SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
				passwordResetEmail.setFrom("shreya.jalihal@gmail.com");
				passwordResetEmail.setTo(customerEntity.getEmailid());
				passwordResetEmail.setSubject("Password Reset Request");
				passwordResetEmail.setText("Hi" + " " + customerEntity.getName() + "\n"
						+ "We received a request to reset the password on your Account." + "\n"
						+ customerEntity.getCode() + "\n" + "Enter this code to complete the reset." + "\n"
						+ "Thanks for helping us keep your account secure." + "\n" + "The ConnectionsApp Team");

				emailService.sendEmail(passwordResetEmail);
				logger.info("Email with a reset code sent");
		} 
		return messageBean;
	}

	/*
	 * Method to verify Code for password change
	 * 
	 * @param String code,String emailId.
	 * 
	 * return MessageBean bean
	 */
	public MessageBean verifyResetCode(String code, String emailId) {
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
	 * Method to save new Password after password change
	 * 
	 * @param CustomerDto customerDto.
	 * 
	 * return MessageBean bean
	 */
	public MessageBean saveCustomerWithNewPassword(CustomerDto customerDto) {
		MessageBean messageBean = new MessageBean();
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
			customerService.updateCustomer(customerEntity);

		} else {
			logger.error("Error occurred while trying to save the customer Entity details with new password");
			messageBean.setError("We experienced an error while saving your new password");
		}
		return messageBean;
	}

}
