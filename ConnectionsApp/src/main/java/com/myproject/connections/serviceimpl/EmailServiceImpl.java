/*@author=Shreya*/

package com.myproject.connections.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.myproject.connections.service.EmailService;
/**
 * @author Shreya S Jalihal
 * EmailServiceImpl method to send email to the customer.
 */
@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	
	/*
	 * Service method to generate and save reset code for changing password and send
	 * an email to the customer with the reset code
	 * 
	 * @param SimpleMailMessage emailId
	 * 
	 * @return null
	 */
	public void sendEmail(SimpleMailMessage emailId) {
		mailSender.send(emailId);
	}

}
