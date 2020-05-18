package com.myproject.connections.security.model;


/* @author Shridha S Jalihal
 * 
 * JWTResponse model sent in the reponse
 * 
 */
public class JWTResponse {

	private final String jwt;
	
	
	
	public JWTResponse(String jwt) {
		this.jwt = jwt;
	}

	
	public String getJwt() {
		return jwt;
	}
	
	
	
}
