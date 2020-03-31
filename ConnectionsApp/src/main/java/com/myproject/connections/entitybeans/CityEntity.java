package com.myproject.connections.entitybeans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="City")
@IdClass(CityPK.class)
@Data
public class CityEntity implements Serializable {	
	
	private static final long serialVersionUID = -7307713924718229168L;
	
	@Id
	@Column(name="c_stateID")
	String cstateID;
	
	@Id
	private String cityName;
	
	/*
	 * @ManyToOne private States stateCity;
	 */
  
	
}
