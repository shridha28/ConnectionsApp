package com.myproject.connections.beans;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Address implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4835979957445506346L;
	
	private String street;
	private String houseNumber;
	private String landMark;
	private String city;
	private String state;
	
}
