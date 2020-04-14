package com.myproject.connections.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.connections.entitybeans.StatesEntity;

/*@author Shridha S Jalihal
 *Repository class StateRepository for States related transactions 
 */
public interface StateRepository extends JpaRepository<StatesEntity, String>{
	
	/*method to find all the states 
	  *@param Sort sort
	  *return List of StateEntity beans 
	  */
	public List<StatesEntity> findAll(Sort sort);
	
	
}
