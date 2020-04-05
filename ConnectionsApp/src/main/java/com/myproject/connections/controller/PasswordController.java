package com.myproject.connections.controller;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myproject.connections.entitybeans.CustomerEntity;
import com.myproject.connections.service.EmailService;
import com.myproject.connections.serviceimpl.CustomerServiceImpl;

/*@author=Shreya*/

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PasswordController {

	@Autowired
	private CustomerServiceImpl customerService;

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;


	@PostMapping(value = "/forgot")
	public ModelAndView processForgotPasswordForm(ModelAndView modelAndView, @RequestBody String emailid,
			HttpServletRequest request) {
		CustomerEntity customerEntity = customerService.getCustomer(emailid);
		Optional<CustomerEntity> optioanlCustomer = Optional.of(customerEntity);

		if (!optioanlCustomer.isPresent()) {
			modelAndView.addObject("errorMessage", "We didn't find an account for that e-mail address.");
		} else {
			// Generate random 36-character string token for reset password
			customerEntity.setResetToken(UUID.randomUUID().toString());

			// save the token to the Database
			customerService.saveCustomer(customerEntity);

			String appUrl = request.getScheme() + ":" + request.getServerName();

			// Email Message
			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();

			passwordResetEmail.setFrom("shreya.jalihal@gmail.com");
			passwordResetEmail.setTo(customerEntity.getEmailid());
			passwordResetEmail.setSubject("Password Reset Request");
			passwordResetEmail.setText("To reset your password, click the link below:\\n" + appUrl + "/reset?token="
					+ customerEntity.getResetToken());

			emailService.sendEmail(passwordResetEmail);

		}

		return modelAndView;
	}
	
	@GetMapping("/reset")
	public ModelAndView displayResetPasswordPage(ModelAndView modelAndView, @RequestParam("token") String token)
	{
		Optional<CustomerEntity> customerEntity=customerService.findUserByResetToken(token);
		if(!customerEntity.isPresent())
		{
			modelAndView.addObject("resetToken", token);
		}else { // Token not found in DB
			modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
		}

		modelAndView.setViewName("resetPassword");
		return modelAndView;
		
	}

	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public ModelAndView setNewPassword(ModelAndView modelAndView, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {

		// Find the user associated with the reset token
		Optional<CustomerEntity> customerEntity = customerService.findUserByResetToken(requestParams.get("token"));

		// This should always be non-null but we check just in case
		if (customerEntity.isPresent()) {
			
			CustomerEntity resetUser = customerEntity.get(); 
            
			// Set new password    
            resetUser.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password")));
            
			// Set the reset token to null so it cannot be used again
			resetUser.setResetToken(null);

			// Save user
			customerService.saveCustomer(resetUser);

			// In order to set a model attribute on a redirect, we must use
			// RedirectAttributes
			redir.addFlashAttribute("successMessage", "You have successfully reset your password.  You may now login.");

			modelAndView.setViewName("redirect:login");
			return modelAndView;
			
		} else {
			modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
			modelAndView.setViewName("resetPassword");	
		}
		
		return modelAndView;
   }
   

}
