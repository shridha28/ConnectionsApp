package com.myproject.connections.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myproject.connections.entitybeans.CityEntity;
import com.myproject.connections.entitybeans.StatesEntity;
import com.myproject.connections.mapper.StateMapper;
import com.myproject.connections.models.StatesDto;
import com.myproject.connections.repository.CityRepository;
import com.myproject.connections.repository.StateRepository;

/**
 * @author acer
 *
 */
@Service
public class StatesServiceImpl {

	@Autowired
	StateMapper stateMapper;

	@Autowired
	StateRepository stateRepository;

	@Autowired
	CityRepository cityRepository;

	public List<StatesEntity> getAllStates() {

		List<StatesEntity> states = stateRepository.findAll(Sort.by(Sort.Direction.ASC, "stateName"));

		states = states.stream().map(s -> {
			String setName = s.getStateName().substring(0, 1) + s.getStateName().substring(1).toLowerCase();
			s.setStateName(setName);
			return s;
		}).collect(Collectors.toList());

		return states;
	}

	public List<CityEntity> getCityPerState(String state) {

		return cityRepository.findByCstateIDOrderByCityNameAsc(state);
	}

	// Example Implementation of Mapping List of StateEntities is mapped to a list of StateDtos//
	//Shreya
	public List<StatesDto> getStates() {

		List<StatesDto> states = stateMapper.getListofStatesDto();
		states = states.stream().map(s -> {
			String setName = s.getStateName().substring(0, 1) + s.getStateName().substring(1).toLowerCase();
			s.setStateName(setName);
			return s;
		}).collect(Collectors.toList());

		return states;

	}

}
