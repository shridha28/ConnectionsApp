package com.myproject.connections.security;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.AuthenticationEntryPoint;
/* @author Shridha S Jalihal
 * 
 *
 *JwtAuthentication Point for JWT
 * 
 */
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
	private static final long serialVersionUID = -7858869558953243875L;

	
	/*
	 * Method to send an error response with unauthorized in case if the token is invalid
	 *  
	 * @param HttpServletRequest request
	 *
	 * @param HttpServletResponse response
	 *  
	 */
	public void commence(HttpServletRequest request, HttpServletResponse response,
			org.springframework.security.core.AuthenticationException authException)
			throws IOException, ServletException {
		
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
		
	}

}
