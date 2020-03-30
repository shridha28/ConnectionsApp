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


@Entity
@Table(name="customers")
public class CustomerDetails extends Auditable<String> implements Serializable{
	
	
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
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public AddressEntity getAddressEntity() {
		return addressEntity;
	}


	public void setAddressEntity(AddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public CustomerDetails() {}
	
	
	public CustomerDetails(Long id, String emailid, Date creation_date, Date modified_date,
			Role role,String password) {
		super();
		this.id = id;
		this.emailid = emailid;
		this.role = role;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

}
