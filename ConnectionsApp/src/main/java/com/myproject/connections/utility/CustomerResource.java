package com.myproject.connections.utility;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.myproject.connections.controller.CustomerController;
import com.myproject.connections.entitybeans.CustomerEntity;
import com.myproject.connections.models.CustomerDto;

/*@author Shreya S Jalihal
 * CustomerResource class to expose Links for HATEOS feature.
 */
@Component
public class CustomerResource extends RepresentationModelAssemblerSupport<CustomerEntity, CustomerDto> {

	ModelMapper modelMapper = new ModelMapper();

	public CustomerResource() {
		super(CustomerController.class, CustomerDto.class);
	}

	/*
	 * Method to get links of URIs for CustomerEntity bean
	 * 
	 * @param CustomerEntity bean
	 * 
	 * @return CustomerDto bean
	 */
	@SuppressWarnings("deprecation")
	public CustomerDto toModel(CustomerEntity customerEntity) {

		CustomerDto customerDto = modelMapper.map(customerEntity, CustomerDto.class);

		customerDto.add(ControllerLinkBuilder.linkTo(
				ControllerLinkBuilder.methodOn(CustomerController.class).getCustomer(customerEntity.getEmailid()))
				.withSelfRel());
		customerDto.add(ControllerLinkBuilder.linkTo(CustomerController.class).withRel("Customers"));
		modelMapper.map(customerEntity, CustomerDto.class);
		return customerDto;
	}

}
