package com.myproject.connections.service;

import com.myproject.connections.entitybeans.MessageBean;
import com.myproject.connections.exceptions.EmailNotFoundException;
import com.myproject.connections.models.CustomerDto;

/*@author Shreya S Jalihal
 *Password Service interface with methods for password forgot and change functionality*/
public interface PasswordSecurityService {
	
	
	public MessageBean sendEmailWithResetCode(String emailId,MessageBean messageBean) throws EmailNotFoundException ;
	public MessageBean verifyResetCode(String code, String emailId);
	public MessageBean saveCustomerWithNewPassword(CustomerDto customerDto);

}
