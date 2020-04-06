package com.myproject.connections.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/*@author Shridha S Jalihal
 * SecurityConfiguration class  for initiating Security related beans
 * */
@Configuration
public class SecurityConfigurer {

	/*
	 * BCryptPasswordEncoder bean for password encryption.
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	/* Let this code be as it is -> PLEASE DON'T DELETE
	 * CorsConfigurationSource bean for enabling CORS (Cross Origin Resource
	 * Sharing).
	 * 
	 * 
	 * @Bean public CorsConfigurationSource corsConfigurationSource() { final
	 * CorsConfiguration configuration = new CorsConfiguration();
	 * configuration.setAllowedOrigins(Arrays.asList("*"));
	 * configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT",
	 * "DELETE", "PATCH"));
	 * configuration.setAllowedHeaders(Arrays.asList("Authorization",
	 * "Cache-Control", "Content-Type")); final UrlBasedCorsConfigurationSource
	 * source = new UrlBasedCorsConfigurationSource();
	 * source.registerCorsConfiguration("/**", configuration); return source; }
	 */
}
