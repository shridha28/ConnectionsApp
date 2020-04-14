package com.myproject.connections.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.connections.entitybeans.Role;

/*@author Shridha S Jalihal
 *Repository class RoleRepository for Role related transactions 
 */
public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	 /*method to find role by rolename - rolename in the entity bean
	  *@param role
	  *return Role bean 
	  */
	 Role findByrolename(String role);
}
