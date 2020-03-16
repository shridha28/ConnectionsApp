package com.myproject.connections.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myproject.connections.beans.CustomerDetails;


public interface CustDetailsRepository extends JpaRepository<CustomerDetails, String>{
	
	@Query("SELECT r.emailid FROM CustomerDetails r where r.emailid = :userName")
	public String findByEmailid(String userName);
	
	
	 
    
}
