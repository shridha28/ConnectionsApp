package com.myproject.connections.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myproject.connections.entitybeans.StatesEntity;
import com.myproject.connections.mapper.StateMapper;
import com.myproject.connections.models.StatesDto;
import com.myproject.connections.repository.CityRepository;
import com.myproject.connections.repository.StateRepository;
import com.myproject.connections.service.StatesService;

/*
 * @author Shridha S Jalihal
 * StatesService Implementation class for the business logic of States related services
 */
@Service
public class StatesServiceImpl implements StatesService {

	@Autowired
	StateMapper stateMapper;

	@Autowired
	StateRepository stateRepository;

	@Autowired
	CityRepository cityRepository;

	/*
	 * method to retrieve list of states from the database
	 *
	 * @return list of StatesDto beans
	 */
	public List<StatesDto> getAllStates() {

		List<StatesDto> states = stateMapper.getListofStatesDto();
		states = states.stream().map(s -> {
			String setName = s.getStateName().substring(0, 1) + s.getStateName().substring(1).toLowerCase();
			s.setStateName(setName);
			return s;
		}).collect(Collectors.toList());

		return states;

	}

	/*
	 * method to retrieve list of StatesEntity beans from the database
	 *
	 * @return list of StatesEntity beans
	 */
	public List<StatesEntity> findAllStates() {
		return stateRepository.findAll(Sort.by(Sort.Direction.ASC, "stateName"));

	}

}
