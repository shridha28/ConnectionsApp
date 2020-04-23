package com.myproject.connections.entitybeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*@author Shreya S Jalihal
 *Entity class for States 
 */
@Data
@Entity
@Table(name="states")
@NoArgsConstructor
@AllArgsConstructor
public class StatesEntity implements Serializable{
	
	private static final long serialVersionUID = 4254428267358544179L;
	
	@Id
	private String stateID;
	private String stateName;
	private Date creation_date;
	private Date  modified_date;
	
	
	@OneToMany /* (cascade=CascadeType.ALL) */
	@JoinColumn(name="c_stateID")
	private List<CityEntity> cities;
	
}
