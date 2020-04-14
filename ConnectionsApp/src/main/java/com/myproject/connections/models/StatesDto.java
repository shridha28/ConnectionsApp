package com.myproject.connections.models;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*@author Shridha S Jalihal
 *Dto class for States 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatesDto {
	
	private String stateID;
	private String stateName;
	private Date creation_date;
	private Date  modified_date;
	
	private List<CityDto> cities;
	

}
