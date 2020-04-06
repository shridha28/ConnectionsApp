package com.myproject.connections.entitybeans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/*@author Shridha S Jalihal
 *Role Entity*/
@Entity
@Table(name="Roles")
public class Role {


	@Id
	private long role_id;
	
	private String rolename;
	
	private Date creation_date;
	
	private Date modified_date;


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
	public long getId() {
		return role_id;
	}
	public void setId(long id) {
		this.role_id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public Role(long id, String rolename) {
		super();
		this.role_id = id;
		this.rolename = rolename;
	}

}
