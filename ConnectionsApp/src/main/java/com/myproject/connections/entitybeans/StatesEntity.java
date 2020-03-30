package com.myproject.connections.entitybeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Entity
@Table(name="States")
@Getter
@Setter
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
	
	
	
	public StatesEntity() {}
	
	
	/*
	 * public Date getCreation_date() { return creation_date; } public void
	 * setCreation_date(Date creation_date) { this.creation_date = creation_date; }
	 * public Date getModified_date() { return modified_date; } public void
	 * setModified_date(Date modified_date) { this.modified_date = modified_date; }
	 * public String getStateID() { return stateID; } public void setStateID(String
	 * stateID) { this.stateID = stateID; } public String getStateName() { return
	 * stateName; } public void setStateName(String stateName) { this.stateName =
	 * stateName; }
	 */	public StatesEntity(String stateID, String stateName, Date creation_date, Date modified_date) {
		super();
		this.stateID = stateID;
		this.stateName = stateName;
		this.creation_date = creation_date;
		this.modified_date = modified_date;
	}

	
	
	
}
