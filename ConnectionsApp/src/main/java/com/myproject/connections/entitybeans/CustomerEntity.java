package com.myproject.connections.entitybeans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.myproject.connections.utility.UniqueEmail;

import lombok.Data;


@Entity
@Data
@Table(name="customers")
public class CustomerEntity extends Auditable<String> implements Serializable{
	
	
	private static final long serialVersionUID = -3617767414915807263L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private String name;
	
	@UniqueEmail
	private String emailid;
	
	@Embedded
	private AddressEntity addressEntity;
	
	private String password;
	
	@OneToOne
	private Role role;
	
	public CustomerEntity() {}
	
	
	public CustomerEntity(Long id, String emailid, Date creation_date, Date modified_date,
			Role role,String password) {
		super();
		this.id = id;
		this.emailid = emailid;
		this.role = role;
		this.password = password;
	}
}
