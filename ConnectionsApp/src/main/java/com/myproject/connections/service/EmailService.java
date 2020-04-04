package com.myproject.connections.service;

import org.springframework.mail.SimpleMailMessage;

/*@author=Shreya*/
public interface EmailService {

	public void sendEmail(SimpleMailMessage  emailId);
	
}
