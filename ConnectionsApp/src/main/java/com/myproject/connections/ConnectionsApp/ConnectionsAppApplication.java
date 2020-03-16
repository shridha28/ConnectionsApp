package com.myproject.connections.ConnectionsApp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication (exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackages= {"com.myproject.connections.*"})
@EnableJpaRepositories("com.myproject.connections.repository")
@EntityScan( basePackages = {"com.myproject.connections.beans"} )
@EnableDiscoveryClient
@Configuration
public class ConnectionsAppApplication {

	private static final Logger logger = LoggerFactory.getLogger(ConnectionsAppApplication.class);
	
	public static void main(String[] args) {
		
		logger.debug("Starting ConnectionsAppApplication");
		SpringApplication.run(ConnectionsAppApplication.class, args);
		logger.debug("Started ConnectionsAppApplication");
		
	}

}
