package com.myproject.connections.test.controller;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.myproject.connections.entitybeans.CustomerEntity;
import com.myproject.connections.main.ConnectionsAppApplication;
import com.myproject.connections.repository.CustDetailsRepository;
import com.myproject.connections.serviceimpl.CustomerServiceImpl;


@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes=ConnectionsAppApplication.class)
@Transactional
public class BasicAuthenticationIntegrationTest {
	
	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;
	
	@MockBean
	CustomerServiceImpl customerServiceImpl;
	
	@Autowired
	BCryptPasswordEncoder encoder;

	@BeforeEach
	public void setup() {
		
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders
				.webAppContextSetup(context)
				.apply(springSecurity())
				.build();
		
	}
	
	
	@Test
	void testAuthentication_correctCredentials() {
		
		CustomerEntity customer = new CustomerEntity();
		customer.setEmailid("shridha.jalihal@gmail.com");
		customer.setPassword(encoder.encode("Akka@1801"));
		when(customerServiceImpl.findByEmailId("shridha.jalihal@gmail.com")).thenReturn(customer);
		try {
			this.mockMvc.perform(get("/api/login")
			.with(httpBasic("shridha.jalihal@gmail.com","Akka@1801")))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Test
	void testAuthentication_inCorrectCredentials() {
		
		CustomerEntity customer = new CustomerEntity();
		customer.setEmailid("shridha.jalihal@gmail.com");
		customer.setPassword(encoder.encode("Akka@1801"));
		when(customerServiceImpl.findByEmailId("shridha.jalihal@gmail.com")).thenReturn(customer);
		try {
			this.mockMvc.perform(get("/api/login")
			.with(httpBasic("shridha.jalihal@gmail.com","Akka@18011")))
            .andDo(print())
            .andExpect(status().is4xxClientError())
            .andReturn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testAuthentication_noAuthHeader() {
		
		CustomerEntity customer = new CustomerEntity();
		customer.setEmailid("shridha.jalihal@gmail.com");
		customer.setPassword(encoder.encode("Akka@1801"));
		when(customerServiceImpl.findByEmailId("shridha.jalihal@gmail.com")).thenReturn(customer);
		try {
			this.mockMvc.perform(get("/api/login")
			.with(httpBasic("shridha.jalihal@gmail.com","Akka@18011")))
            .andDo(print())
            .andExpect(status().is4xxClientError())
            .andReturn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
