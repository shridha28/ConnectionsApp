package com.myproject.connections.entitybeans;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.myproject.connections.utility.UniqueEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@author Shridha S Jalihal
 *Customer Entity to save CustomerDetails in the database*/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class CustomerEntity extends Auditable<String> implements Serializable {

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

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "emailid"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	private String code;

}
