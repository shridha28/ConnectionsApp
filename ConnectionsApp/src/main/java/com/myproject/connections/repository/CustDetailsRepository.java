package com.myproject.connections.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.myproject.connections.entitybeans.CustomerEntity;


public interface CustDetailsRepository extends JpaRepository<CustomerEntity, String>{
	
	
	/*Method to get CustomerDetails data based on EmaiID
	 *@param emailid
	 *@return CustomerDetails sql bean
	 */
	@Query("SELECT r FROM CustomerEntity r where r.emailid = :emailid")
	public CustomerEntity findByEmailid(String emailid);
    
}
