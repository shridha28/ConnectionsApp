/*@author=Shreya*/

package com.myproject.connections.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.myproject.connections.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(SimpleMailMessage emailId) {
		mailSender.send(emailId);
	}

}
