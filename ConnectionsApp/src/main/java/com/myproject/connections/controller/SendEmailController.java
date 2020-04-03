package com.myproject.connections.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.connections.exceptions.EmailNotFoundException;


 
/**@author Shridha S Jalihal
 * Contoller class to  retrieve emailid and process it to send
 * an email to reset password
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SendEmailController {
	
	
	private static Logger logger = LoggerFactory.getLogger(SendEmailController.class);
	
	
	/*Method receives emailid from the user to receive a password reset link
	 * @param emailid through path variable
	 * @throws EmailNotFoundException
	 * */
	@GetMapping("/api/sendemail/{emailid}")
	public void getEmailToSendMail(@PathVariable("emailid") String emailid)throws EmailNotFoundException{
		System.out.println(emailid);
	}
	

}
