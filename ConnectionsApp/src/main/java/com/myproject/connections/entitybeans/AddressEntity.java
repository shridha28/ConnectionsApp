package com.myproject.connections.entitybeans;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity implements Serializable{
	
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
