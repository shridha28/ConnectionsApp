package com.myproject.connections.ConnectionsApp;

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

	public static void main(String[] args) {
		SpringApplication.run(ConnectionsAppApplication.class, args);
	}

}
