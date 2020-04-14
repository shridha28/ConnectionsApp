package com.myproject.connections.entitybeans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@author Shridha S Jalihal
 *Role Entity*/
@Entity
@Table(name = "Roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

	@Id
	private long role_id;

	private String rolename;

	private Date creation_date;

	private Date modified_date;

}
