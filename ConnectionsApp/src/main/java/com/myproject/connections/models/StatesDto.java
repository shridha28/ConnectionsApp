package com.myproject.connections.models;

/*@author="Shreya"*/
//Created a Dto/Pojo class for States_27032020// 
import java.util.Date;
import java.util.List;

import com.myproject.connections.entitybeans.CityEntity;

import lombok.Data;

@Data
public class StatesDto {
	
	private String stateID;
	private String stateName;
	private Date creation_date;
	private Date  modified_date;
	
	private List<CityEntity> cities;
	

}
