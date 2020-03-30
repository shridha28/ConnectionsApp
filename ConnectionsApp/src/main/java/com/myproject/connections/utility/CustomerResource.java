package com.myproject.connections.utility;

import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.myproject.connections.controller.CustomerController;
import com.myproject.connections.entitybeans.CustomerDetails;
import com.myproject.connections.models.CustomerModel;

import lombok.Getter;

@Getter
@Component
public class CustomerResource extends RepresentationModelAssemblerSupport<CustomerDetails,CustomerModel> {

	public CustomerResource()
	{
		super(CustomerController.class,CustomerModel.class);
	}
	
	
	@SuppressWarnings("deprecation")
	public CustomerModel toModel(CustomerDetails details)
	{
		CustomerModel model= instantiateModel(details);
		model.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(CustomerController.class).getCustomer(details.getEmailid())).withSelfRel());
		model.setEmailid(details.getEmailid());
		model.setName(details.getName());
		
		return model;
	
	
	}
	
	
	
	/*
	 * private final CustomerDetails customerdetails;
	 * 
	 * @SuppressWarnings("deprecation") public CustomerResource(final
	 * CustomerDetails customerdetails) { this.customerdetails = customerdetails;
	 * final String emailId = customerdetails.getEmailid();
	 * add(ControllerLinkBuilder.linkTo(CustomerController.class).withRel(
	 * "customers"));
	 * add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(
	 * CustomerController.class).getCustomer(emailId)) .withSelfRel()); }
	 */

}
