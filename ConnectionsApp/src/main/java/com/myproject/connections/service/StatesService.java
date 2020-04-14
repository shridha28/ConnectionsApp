package com.myproject.connections.service;

import java.util.List;

import com.myproject.connections.entitybeans.StatesEntity;
import com.myproject.connections.models.StatesDto;

/*@author Shreya S Jalihal
 *States Service interface*/
public interface StatesService {

	public List<StatesDto> getAllStates();

	public List<StatesEntity> findAllStates();
}
