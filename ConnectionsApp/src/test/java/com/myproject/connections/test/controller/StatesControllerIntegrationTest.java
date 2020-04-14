package com.myproject.connections.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.myproject.connections.controller.StatesController;
import com.myproject.connections.main.ConnectionsAppApplication;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT,classes = StatesController.class)
@ContextConfiguration(classes=ConnectionsAppApplication.class)
class StatesControllerIntegrationTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;
	
	
	@BeforeEach 
	public void setUp() {

	
		mockMvc = MockMvcBuilders
				.webAppContextSetup(context)
				.build();
	}

	@Test
	void getStatesData_Shouldload_StatesWithCities() {
		try {
			mockMvc.perform(get("/getStatesData")
				    .contentType("application/json"))
					.andDo(print())
				    .andExpect(status().isOk())
				    .andExpect(MockMvcResultMatchers.jsonPath("$.[*].stateID").exists())
				    .andExpect(MockMvcResultMatchers.jsonPath("$.[*].cities").isNotEmpty());;
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	

}
