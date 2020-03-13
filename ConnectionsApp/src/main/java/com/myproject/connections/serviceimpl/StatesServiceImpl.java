package com.myproject.connections.serviceimpl;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.connections.beans.States;
import com.myproject.connections.repository.StateRepository;

@Service
public class StatesServiceImpl {
	
	@Autowired
	StateRepository stateRepository;
	
	public List<States> getAllStates(){
	List<States> states = stateRepository.findAll();
		
	 states = states.stream().map(s->{
		 String setName = s.getStateName().substring(0, 1)+
				 s.getStateName().substring(1).toLowerCase();
		 s.setStateName(setName);
		return s;
		 }).collect(Collectors.toList());
		
	 return states;
	}

}
