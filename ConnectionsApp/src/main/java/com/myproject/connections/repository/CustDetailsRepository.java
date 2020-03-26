package com.myproject.connections.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myproject.connections.entitybeans.CustomerDetails;


public interface CustDetailsRepository extends JpaRepository<CustomerDetails, String>{
	
	
	/*Method to get CustomerDetails data based on EmaiID
	 *@param emailid
	 *@return CustomerDetails sql bean
	 */
	@Query("SELECT r FROM CustomerDetails r where r.emailid = :emailid")
	public CustomerDetails findByEmailid(String emailid);
    
}
