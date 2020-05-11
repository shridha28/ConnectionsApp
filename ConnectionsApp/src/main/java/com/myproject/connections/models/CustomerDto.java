package com.myproject.connections.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@author Shridha S Jalihal
 *Dto class for Customer 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto extends RepresentationModel<CustomerDto> implements Serializable {

	private static final long serialVersionUID = -3617767414915807263L;

	@NotNull
	private String username;

	@NotNull
	private String emailid;

	private String linkedInUrl;

	private ImageModel imageModel;

	private String technologies;

	private String code;

	@NotNull
	private String password;

	private Date creation_date;

	private Date modified_date;

	public CustomerDto(String emailid, Date creation_date, Date modified_date, String password) {
		super();

		this.emailid = emailid;
		this.creation_date = creation_date;
		this.modified_date = modified_date;
		this.password = password;
	}

}
