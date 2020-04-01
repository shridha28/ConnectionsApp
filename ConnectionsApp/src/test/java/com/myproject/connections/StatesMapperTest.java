package com.myproject.connections;

/*@author=Shreya*/
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myproject.connections.entitybeans.CityEntity;
import com.myproject.connections.entitybeans.StatesEntity;
import com.myproject.connections.models.CityDto;
import com.myproject.connections.models.StatesDto;

public class StatesMapperTest {
	
	private ModelMapper modelMapper=new ModelMapper();
	
    private static Logger logger = LoggerFactory.getLogger(StatesMapperTest.class);

	@Test
	public void whenConvertStatesDtoToStatesEntity()
	
	{
		logger.info("Creating a Mock Object for StatesDto");
		StatesDto statesDto=new StatesDto();
		statesDto.setStateName("Karnataka");
		@SuppressWarnings("deprecation")
		Date createdDate=new Date("11/02/1990");
		statesDto.setCreation_date(createdDate);	
		@SuppressWarnings("deprecation")
		Date modifiedDate=new Date("12/12/1990");
		statesDto.setModified_date(modifiedDate);
		List<CityDto> citiesDto=Arrays.asList(new CityDto("KA","Bangalore"),
				new CityDto("KA","Mysore"));
		statesDto.setCities(citiesDto);
		logger.info("Mapping StatesDto Object to StatesEntity Object using ModelMapper");
		StatesEntity statesEntity=modelMapper.map(statesDto,StatesEntity.class);
		
		assertEquals(statesDto.getStateName(),statesEntity.getStateName());
		assertEquals(statesDto.getCreation_date(),statesEntity.getCreation_date());
		assertEquals(statesDto.getModified_date(),statesEntity.getModified_date());
		logger.info("Confirming if the list of cityDto Objects in StateDto is mapped to list of CityEntity Objects in State Entity Object");
		assertNotEquals(statesDto.getCities(),statesEntity.getCities());
		assertEquals(statesDto.getCities().get(0).getCityName(),statesEntity.getCities().get(0).getCityName());
		assertEquals(statesDto.getCities().get(1).getCityName(),statesEntity.getCities().get(1).getCityName());
		
		assertEquals(statesDto.getCities().get(0).getCstateID(),statesEntity.getCities().get(0).getCstateID());
		assertEquals(statesDto.getCities().get(1).getCstateID(),statesEntity.getCities().get(1).getCstateID());
	}	
	
	
	
	  @Test public void whenConvertStatesEntityToStatesDto()
	  
	  { logger.info("Creating a Mock Object for StatesEntity"); StatesEntity
	  statesEntity1=new StatesEntity(); statesEntity1.setStateName("Karnataka");
	  
	  @SuppressWarnings("deprecation") Date createdDate=new Date("11/02/1990");
	  statesEntity1.setCreation_date(createdDate);
	  
	  @SuppressWarnings("deprecation") Date modifiedDate=new Date("12/12/1990");
	  statesEntity1.setModified_date(modifiedDate); List<CityEntity>
	  citiesEntity=Arrays.asList(new CityEntity("KA","Bangalore"), new
	  CityEntity("KA","Mysore")); statesEntity1.setCities(citiesEntity); logger.
	  info("Mapping StatesEntity Object to StatesDto Object using ModelMapper");
	  StatesDto statesDto1=modelMapper.map(statesEntity1,StatesDto.class);
	  
	  assertEquals(statesEntity1.getStateName(),statesDto1.getStateName());
	  assertEquals(statesEntity1.getCreation_date(),statesDto1.getCreation_date());
	  assertEquals(statesEntity1.getModified_date(),statesDto1.getModified_date());
	  logger.
	  info("Confirming if the list of cityEntity1 Objects in StateEntity1 is mapped to list of CityDto1 Objects in State Dto Object"
	  ); assertNotEquals(statesEntity1.getCities(),statesDto1.getCities());
	  assertEquals(statesEntity1.getCities().get(0).getCityName(),statesDto1.
	  getCities().get(0).getCityName());
	  assertEquals(statesEntity1.getCities().get(1).getCityName(),statesDto1.
	  getCities().get(1).getCityName());
	  assertEquals(statesEntity1.getCities().get(0).getCstateID(),statesDto1.
	  getCities().get(0).getCstateID());
	  assertEquals(statesEntity1.getCities().get(1).getCstateID(),statesDto1.
	  getCities().get(1).getCstateID()); }
	 
}