package com.myproject.connections.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myproject.connections.entitybeans.CustomerEntity;
/**Class CustDetailsRepository.The repository class for customer to communicate with the database.
 * @author Shridha S Jalihal
 *
 */
@Repository
public interface CustDetailsRepository extends JpaRepository<CustomerEntity, String>{


	/*Method to get CustomerDetails data based on EmaiID
	 *@param emailid
	 *@return CustomerEntity bean
	 */
	@Query("SELECT r FROM CustomerEntity r where r.emailid = :emailid")
	public CustomerEntity findByEmailid(String emailid);

}
