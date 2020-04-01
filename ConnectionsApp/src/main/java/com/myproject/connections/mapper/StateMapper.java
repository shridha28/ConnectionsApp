package com.myproject.connections.mapper;

/*@author=Shreya*/
/*&Mapper class for States*/
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.myproject.connections.entitybeans.StatesEntity;
import com.myproject.connections.models.StatesDto;
import com.myproject.connections.repository.StateRepository;

@Component
public class StateMapper {
	
    private static Logger logger = LoggerFactory.getLogger(StateMapper.class);


	@Autowired
	StateRepository stateRepository;
	
	@Autowired
	CityMapper cityMapper;

	ModelMapper modelMapper = new ModelMapper();

	public StatesEntity convertToEntity(StatesDto statesDto) throws ParseException {
		logger.info("Mapping StatesDto Object to StatesEntity Object");
		StatesEntity statesEntity = modelMapper.map(statesDto, StatesEntity.class);
		return statesEntity;
	}

	public StatesDto convertToDto(StatesEntity statesEntity) {
		logger.info("Mapping StatesEntity Object to StatesDto Object");
		StatesDto statesDto = modelMapper.map(statesEntity, StatesDto.class);

		return statesDto;
	}

	public List<StatesDto> getListofStatesDto() {
		logger.info("Mapping list of StatesEntity Objects to list of StatesDto Objects");
		List<StatesEntity> statesEntityList = stateRepository.findAll(Sort.by(Sort.Direction.ASC, "stateName"));
		Type listType = new TypeToken<List<StatesDto>>() {
		}.getType();
		
		List<StatesDto> statesDtoList = modelMapper.map(statesEntityList, listType);
		
		return statesDtoList;
	}

	public List<StatesEntity> getListofCitiesEntity(List<StatesDto> listStatesEntity) {
		logger.info("Mapping list of StatesDto Objects to list of StatesEntity Objects");
		Type listType = new TypeToken<List<StatesEntity>>() {
		}.getType();
		
		List<StatesEntity> statesEntityList = modelMapper.map(listStatesEntity, listType);
		return statesEntityList;
	}

}
