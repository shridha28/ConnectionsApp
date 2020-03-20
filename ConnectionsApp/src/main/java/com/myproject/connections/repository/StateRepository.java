package com.myproject.connections.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.connections.entitybeans.States;


public interface StateRepository extends JpaRepository<States, String>{
	
	
	public List<States> findAll(Sort sort);
	
	
}