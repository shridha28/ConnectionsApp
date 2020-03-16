package com.myproject.connections.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.connections.beans.City;
import com.myproject.connections.beans.States;
import com.myproject.connections.serviceimpl.StatesServiceImpl;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StatesController {
	
	
    private static Logger logger = LoggerFactory.getLogger(StatesController.class);
	
	@Autowired
	StatesServiceImpl stateService;
	
	@GetMapping("/getStatesData")
	public List<States> getStates(){
		logger.info("Retrieving list of states");
		List<States> listOfStates = stateService.getAllStates();
		return listOfStates;
		
	}
	
	@GetMapping("/getStatesData/{stateID}")
	public List<City> getCitiesPerState(@PathVariable("stateID") String state){
		List<City> cities = stateService.getCityPerState(state);
		return cities;
	}

}
