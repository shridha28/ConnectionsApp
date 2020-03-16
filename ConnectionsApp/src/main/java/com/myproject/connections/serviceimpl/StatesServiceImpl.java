package com.myproject.connections.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myproject.connections.beans.City;
import com.myproject.connections.beans.States;
import com.myproject.connections.repository.CityRepository;
import com.myproject.connections.repository.StateRepository;

/**
 * @author acer
 *
 */
@Service
public class StatesServiceImpl {
	
	@Autowired
	StateRepository stateRepository;

	@Autowired
	CityRepository cityRepository;
	
	public List<States> getAllStates(){
		
	List<States> states = stateRepository.findAll(Sort.by(Sort.Direction.ASC, "stateName"));
		
	 states = states.stream().map(s->{
		 String setName = s.getStateName().substring(0, 1)+
				 s.getStateName().substring(1).toLowerCase();
		 s.setStateName(setName);
		return s;
		 }).collect(Collectors.toList());
		
	 return states;
	}
	
	
	public List<City> getCityPerState(String state){
		return cityRepository.findByCstateIDOrderByCityNameAsc(state);
	}

}
