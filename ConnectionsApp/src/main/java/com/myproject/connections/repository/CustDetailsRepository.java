package com.myproject.connections.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myproject.connections.entitybeans.CustomerEntity;

@Repository
public interface CustDetailsRepository extends JpaRepository<CustomerEntity, String>{
	
	
	/*Method to get CustomerDetails data based on EmaiID
	 *@param emailid
	 *@return CustomerDetails sql bean
	 */
	@Query("SELECT r FROM CustomerEntity r where r.emailid = :emailid")
	public CustomerEntity findByEmailid(String emailid);
	
	/*Method to retrieve CustomerEntity bean based on code
	 *@param String code
	 *@return Optional<CustomerEntity> Bean
	 */
	Optional<CustomerEntity> findByCode(String code);
	
    
}
