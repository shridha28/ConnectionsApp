package com.myproject.connections.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.connections.beans.CustomerDetails;


public interface CustDetailsRepository extends JpaRepository<CustomerDetails, String>{
	
	
	public CustomerDetails findByEmailid(String userName);
}
