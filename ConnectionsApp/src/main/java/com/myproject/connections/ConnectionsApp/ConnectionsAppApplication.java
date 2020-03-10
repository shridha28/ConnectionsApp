package com.myproject.connections.ConnectionsApp;

import javax.validation.Validator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@SpringBootApplication (exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackages= {"com.myproject.connections.*"})
@EnableJpaRepositories("com.myproject.connections.repository")
@EntityScan( basePackages = {"com.myproject.connections.beans"} )
@EnableDiscoveryClient
@Configuration
public class ConnectionsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectionsAppApplication.class, args);
	}

	
	/*
	 * @Primary
	 * 
	 * @Bean public Validator validator () { return new LocalValidatorFactoryBean();
	 * }
	 * 
	 * @Bean public MethodValidationPostProcessor methodValidationPostProcessor() {
	 * MethodValidationPostProcessor methodValidationPostProcessor = new
	 * MethodValidationPostProcessor();
	 * methodValidationPostProcessor.setValidator(validator()); return
	 * methodValidationPostProcessor; }
	 */
}
