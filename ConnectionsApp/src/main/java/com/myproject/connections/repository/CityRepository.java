package com.myproject.connections.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.connections.entitybeans.City;


public interface CityRepository extends JpaRepository<City, String>{
	
	public List<City> findByCstateIDOrderByCityNameAsc(String stateID);
	
	
	 
    
}
