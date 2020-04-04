package com.myproject.connections.exceptions;


/*@author Shridha S Jalihal.
 * Throw exception for email not found
 */
public class EmailNotFoundException extends ConnectionsException {

	public EmailNotFoundException(String message) {
		super(message);
	}

}
