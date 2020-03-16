package com.myproject.connections.service;

import java.util.List;

import com.myproject.connections.beans.City;
import com.myproject.connections.beans.States;

public interface StatesService {
	
	
	public List<States> getAllStates();
	public List<City> getCitiesPerState(String state);
}
