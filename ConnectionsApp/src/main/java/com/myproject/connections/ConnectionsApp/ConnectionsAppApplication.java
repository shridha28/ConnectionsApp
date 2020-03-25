package com.myproject.connections.ConnectionsApp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.myproject.connections.entitybeans.BeanAuditorAware;



@SpringBootApplication (exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackages= {"com.myproject.connections.*"})
@EnableJpaRepositories("com.myproject.connections.repository")
@EntityScan( basePackages = {"com.myproject.connections.entitybeans"} )
//@EnableDiscoveryClient
@Configuration
@EnableJpaAuditing(auditorAwareRef="auditorAware")
public class ConnectionsAppApplication {

	private static final Logger logger = LoggerFactory.getLogger(ConnectionsAppApplication.class);
	
	// autowire for auditor Aware implemented class
	@Bean
	public AuditorAware<String> auditorAware() {
		return new BeanAuditorAware();
	}
	
	public static void main(String[] args) {
		
		logger.debug("Starting ConnectionsAppApplication");
		SpringApplication.run(ConnectionsAppApplication.class, args);
		logger.debug("Started ConnectionsAppApplication");
		
	}
	
	
	/*
	 * @Bean public CorsConfigurationSource corsConfigurationSource() { final
	 * CorsConfiguration configuration = new CorsConfiguration();
	 * configuration.setAllowedOrigins("*"); configuration.setAllowedMethods(new
	 * List<String>{"HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
	 * configuration.setAllowCredentials(true);
	 * configuration.setAllowedHeaders(ImmutableList.of("*"));
	 * configuration.setExposedHeaders(ImmutableList.of("X-Auth-Token",
	 * "Authorization","Access-Control-Allow-Origin",
	 * "Access-Control-Allow-Credentials")); final UrlBasedCorsConfigurationSource
	 * source = new UrlBasedCorsConfigurationSource();
	 * source.registerCorsConfiguration("/**", configuration); return source; }
	 */

}
