package com.myproject.connections.service;

import java.util.List;

import com.myproject.connections.entitybeans.CityEntity;
import com.myproject.connections.models.StatesDto;

/*@author Shreya S Jalihal
 *States Service interface*/
public interface StatesService {

	public List<StatesDto> getAllStates();
	public List<CityEntity> getCityPerState(String state);
}
