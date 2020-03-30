package com.myproject.connections.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.connections.entitybeans.CityEntity;


public interface CityRepository extends JpaRepository<CityEntity, String>{
	
	public List<CityEntity> findByCstateIDOrderByCityNameAsc(String stateID);
	
	
	 
    
}
