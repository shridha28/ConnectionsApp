package com.myproject.connections.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.connections.entitybeans.CityEntity;

/*@author Shridha S Jalihal
 *Repository class CityRepository for CityEntity related transactions 
 */
public interface CityRepository extends JpaRepository<CityEntity, String> {

	
	/*Method to get list of CityEntity beans based on StateID
	 *@param String stateID
	 *@return List of CityEntity beans
	 */
	public List<CityEntity> findByCstateIDOrderByCityNameAsc(String stateID);
}
