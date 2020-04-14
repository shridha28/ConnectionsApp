package com.myproject.connections.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.connections.entitybeans.CityEntity;
import com.myproject.connections.models.StatesDto;
import com.myproject.connections.serviceimpl.StatesServiceImpl;

/**
 * Class CustomerController. The contoller for States api requests.
 * 
 * @author Shridha S Jalihal
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StatesController {

	private static Logger logger = LoggerFactory.getLogger(StatesController.class);

	@Autowired
	StatesServiceImpl stateService;

	/*
	 * End Point to get cities associated with a stateID from the database
	 * 
	 * @pathvariable String state
	 *
	 * @return list of CityEntity objects
	 */
	@GetMapping("/getStatesData/{stateID}")
	public List<CityEntity> getCitiesPerState(@PathVariable("stateID") String state) {

		List<CityEntity> cities = stateService.getCityPerState(state);
		return cities;
	}

	/*
	 * End Point to get all States
	 * 
	 * @return Iterable list of StatesDto beans
	 */
	@GetMapping("/getStatesData")
	public Iterable<StatesDto> getAllStates() {
		logger.info("Retrieving list of states");
		Iterable<StatesDto> listofStatesDto = new ArrayList<>();
		listofStatesDto = stateService.getAllStates();
		return listofStatesDto;

	}

}
