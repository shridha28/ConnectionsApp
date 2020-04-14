package com.myproject.connections.service;

import org.springframework.mail.SimpleMailMessage;

/*@author Shreya S Jalihal
 *Email Service interface to send an email to the customer with a code*/
public interface EmailService {

	/*
	 * Service method to generate and save reset code for changing password and send
	 * an email to the customer with the reset code
	 * 
	 * @param SimpleMailMessage emailId
	 * 
	 * @return null
	 */
	public void sendEmail(SimpleMailMessage emailId);

}
