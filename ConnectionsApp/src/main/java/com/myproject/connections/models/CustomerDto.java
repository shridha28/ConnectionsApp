package com.myproject.connections.models;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;


@Data
public class CustomerModel extends RepresentationModel<CustomerModel> implements Serializable{
	
	
	private static final long serialVersionUID = -3617767414915807263L;
	
	private String name;
	
	
	private String emailid;
	
	private String street;
	private String houseNumber;
	private String landMark;
	private String city;
	private String state;
	
	
	@NotNull
	private String password;
    
	private Date creation_date;
	
	private Date  modified_date;

	
	
	public CustomerModel(String emailid, Date creation_date, Date modified_date,
			String password) {
		super();
		
		this.emailid = emailid;
		this.creation_date = creation_date;
		this.modified_date = modified_date;
		//this.role = role;
		this.password = password;
	}
	

}
