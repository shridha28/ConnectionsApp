package com.myproject.connections.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;

@Entity
@IdClass(CityPK.class)
@Data
public class City implements Serializable {	
	
	private static final long serialVersionUID = -7307713924718229168L;
	
	@Id
	@Column(name="c_stateID")
	String cstateID;
	
	@Id
	private String cityName;
  
	
}
