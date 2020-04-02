package com.myproject.connections.models;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CustomerDto extends RepresentationModel<CustomerDto> implements Serializable{
	
	
	private static final long serialVersionUID = -3617767414915807263L;
	
	private String name;
	
	
	private String emailid;
	
	private String street;
	private String houseNumber;
	private String landMark;
	private String city;
	private String state;
	
	
	@NotNull
	@JsonIgnore
	private String password;
    
	private Date creation_date;
	
	private Date  modified_date;

	
	
	public CustomerDto(String emailid, Date creation_date, Date modified_date,
			String password) {
		super();
		
		this.emailid = emailid;
		this.creation_date = creation_date;
		this.modified_date = modified_date;
		//this.role = role;
		this.password = password;
	}
	

}
