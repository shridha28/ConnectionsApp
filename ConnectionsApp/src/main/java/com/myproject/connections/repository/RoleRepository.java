package com.myproject.connections.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myproject.connections.entitybeans.CustomerDetails;
import com.myproject.connections.entitybeans.Role;


public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	 /*method to find role by rolename - rolename in the entity bean
	  *@param role
	  */
	 Role findByrolename(String role);
}
