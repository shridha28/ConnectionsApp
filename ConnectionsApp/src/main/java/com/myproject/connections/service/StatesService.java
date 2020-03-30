package com.myproject.connections.service;

import java.util.List;

import com.myproject.connections.entitybeans.CityEntity;
import com.myproject.connections.entitybeans.StatesEntity;

public interface StatesService {
	
	
	public List<StatesEntity> getAllStates();
	public List<CityEntity> getCitiesPerState(String state);
}
