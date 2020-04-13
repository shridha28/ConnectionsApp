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
import lombok.Getter;
import lombok.NoArgsConstructor;
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
	
	public StatesEntity(String stateID, String stateName, Date creation_date, Date modified_date) {
		super();
		this.stateID = stateID;
		this.stateName = stateName;
		this.creation_date = creation_date;
		this.modified_date = modified_date;
	}

	
	
	
}
