package com.myproject.connections.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.connections.entitybeans.MessageBean;
import com.myproject.connections.models.CustomerDto;
import com.myproject.connections.security.serviceimpl.PasswordSecurityServiceImpl;
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
	private PasswordSecurityServiceImpl passwordSecurityServiceImpl;

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
		logger.info("Calling PasswordSecurityServiceImpl to send an email on" + emailId + " " + "with a reset Code");
		return passwordSecurityServiceImpl.sendEmailWithResetCode(emailId);

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
		logger.info("Calling PasswordSecurityServiceImpl to verify the reset Code sent on the Cusromer's emailId");
		return passwordSecurityServiceImpl.verifyResetCode(code, emailId);
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
		return passwordSecurityServiceImpl.saveCustomerwithnewPassword(customerDto);
	}
}