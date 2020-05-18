package com.myproject.connections.security;



import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;




/* @author Shridha S Jalihal
 * 
 *
 * Util class for JWT related operations
 * 
 */
@Service
public class JWTUtil {
	
	
	
	@Value("${jwt.secret}")
	private String secret;
	

	/*
	 * Method to extract userName using the token
	 *  
	 * @param token of the Customer
	 * 
	 * @return Username(emailId) of the Customer
	 */
	public String extractUserName(String token) {
		return extractClaim(token,Claims::getSubject);
	}
	
	/*
	 * Method to extract expiration Date using the token
	 *  
	 * @param token of the Customer
	 * 
	 * @return expiry Date of the token
	 */
	public Date extractExpiration(String token) {
		return extractClaim(token,Claims::getExpiration);
	}
	
	/*
	 * Method to extract particular claim using the token
	 *  
	 * @param token of the Customer
	 * 
	 * @param claimsResolver 
	 * 
	 * @return claim
	 */
	public<T>T extractClaim(String token,Function<Claims,T> claimsResolver){
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	/*
	 * Method to extract all the claims using token
	 *  
	 * @param token of the Customer
	 * 
	 * @return claims
	 */
	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	
	/*
	 * Method to extract particular claim using the token
	 *  
	 * @param token of the Customer
	 *  
	 * @return claim
	 */
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	/*
	 * Method to generate token using UserDetails
	 *  
	 * @param UserDetails userDetails
	 * 
	 * @return token
	 */
	public String generateToken(UserDetails userDetails) {
		Map<String,Object> claims = new HashMap<>();
		return createToken(claims,userDetails.getUsername());
	}
	
	/*
	 * Method to create token
	 *  
	 * @param Map claims
	 * 
	 * @param String subject 
	 * 
	 * @return token
	 */
	public String createToken(Map<String,Object>claims,String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+ 1000*60*60*10))
				.signWith(SignatureAlgorithm.HS256, secret).compact();
	}
	
	
	/*
	 * Validate token
	 *  
	 * @param token of the Customer
	 * 
	 * @param UserDetails userdetails 
	 * 
	 * @return Boolean to check validity of the token
	 */
	public Boolean validateToken (String token,UserDetails userDetails) {
		final String userName = extractUserName(token);
		return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
