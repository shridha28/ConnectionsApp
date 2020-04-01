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
public class CustomerResource extends RepresentationModelAssemblerSupport<CustomerDetails, CustomerModel> {

	public CustomerResource() {
		super(CustomerController.class, CustomerModel.class);
	}

	@SuppressWarnings("deprecation")
	public CustomerModel toModel(CustomerDetails details) {

		CustomerModel customerModel = instantiateModel(details);

		customerModel.add(ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(CustomerController.class).getCustomer(details.getEmailid()))
				.withSelfRel());
		customerModel.setEmailid(details.getEmailid());
		customerModel.setName(details.getName());

		return customerModel;
	}

}
