/**
 * 
 */
package com.myproject.connections.entitybeans;

import java.io.Serializable;

import lombok.Data;

/**
 * @author acer
 *
 */
@Data
public class CityPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2434224708118139402L;

	
	private String cstateID;
	
	private String cityName;
}
