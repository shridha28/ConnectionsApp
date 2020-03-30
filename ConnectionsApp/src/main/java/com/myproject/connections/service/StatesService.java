package com.myproject.connections.service;

import java.util.List;

import com.myproject.connections.entitybeans.City;
import com.myproject.connections.entitybeans.States;

public interface StatesService {
	
	
	public List<States> getAllStates();
	public List<City> getCitiesPerState(String state);
}
