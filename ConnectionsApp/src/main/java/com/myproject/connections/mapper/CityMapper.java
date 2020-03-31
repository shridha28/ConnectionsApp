package com.myproject.connections.mapper;


/*@author=Shreya*/
/*&Mapper class for City*/
import java.text.ParseException;
import java.util.List;
import java.lang.reflect.Type;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.myproject.connections.entitybeans.CityEntity;
import com.myproject.connections.models.CityDto;
import com.myproject.connections.repository.CityRepository;

public class CityMapper {
	
    private static Logger logger = LoggerFactory.getLogger(CityMapper.class);


	@Autowired
	CityRepository cityRepository;

	ModelMapper modelMapper = new ModelMapper();

	public CityEntity convertToEntity(CityDto cityDto) throws ParseException {
		logger.info("Mapping CityDto Object to CityEntity Object");
		CityEntity cityEntity = modelMapper.map(cityDto, CityEntity.class);
		return cityEntity;
	}

	public CityDto convertToDto(CityEntity cityEntity) {
		logger.info("Mapping CityEntity Object to CityDto Object");
		CityDto cityDto = modelMapper.map(cityEntity, CityDto.class);
		return cityDto;
	}

	public List<CityDto> getListofCitiesDto() {
		logger.info("Mapping list of CityEntity Objects to list of CityDto Objects");
		List<CityEntity> citiesList = cityRepository.findAll();
		Type listType = new TypeToken<List<CityDto>>() {
		}.getType();
		List<CityDto> cityDtoList = modelMapper.map(citiesList, listType);

		return cityDtoList;
	}

	public List<CityEntity> getListofCitiesEntity(List<CityDto> listCityDto) {
		logger.info("Mapping list of CityDto Objects to list of CityEntity Objects");
		Type listType = new TypeToken<List<CityEntity>>() {
		}.getType();
		List<CityEntity> cityEntityList = modelMapper.map(listCityDto, listType);

		return cityEntityList;
	}

}
