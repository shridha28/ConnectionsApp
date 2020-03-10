package com.myproject.connections.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.myproject.connections.service.CustomerService;
import com.myproject.connections.utility.UniqueEmail;

@Entity
public class CustomerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@UniqueEmail
	private String emailid;
	
	@NotNull
	private String password;
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	private Date creation_date;
	private Date  modified_date;
	@OneToOne
	private Role role;
	
	
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
		this.creation_date = creation_date;
		this.modified_date = modified_date;
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
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	public Date getModified_date() {
		return modified_date;
	}
	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}

}
