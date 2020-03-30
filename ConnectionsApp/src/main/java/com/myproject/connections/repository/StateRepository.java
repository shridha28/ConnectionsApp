package com.myproject.connections.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.connections.entitybeans.StatesEntity;


public interface StateRepository extends JpaRepository<StatesEntity, String>{
	
	
	public List<StatesEntity> findAll(Sort sort);
	
	
}
