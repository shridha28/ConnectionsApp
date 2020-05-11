package com.myproject.connections.utility;

import org.springframework.web.multipart.MultipartFile;
import com.myproject.connections.entitybeans.CustomerEntity;
import com.myproject.connections.models.CustomerDto;

/*@author Shreya S Jalihal
 *Mapper Service interface for methods responsible for mapping of/to Objects
 */
public interface Mapper {
	
	public CustomerEntity mapToCustomerEntity(CustomerEntity customerEntity,MultipartFile file,CustomerDto customerDto);
	public CustomerDto mapToCustomerDto(String model);
	
}
