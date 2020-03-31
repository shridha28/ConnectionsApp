package com.myproject.connections.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.connections.entitybeans.AddressEntity;
import com.myproject.connections.entitybeans.CustomerDetails;
import com.myproject.connections.entitybeans.MessageBean;
import com.myproject.connections.models.CustomerModel;
import com.myproject.connections.repository.CustDetailsRepository;
import com.myproject.connections.serviceimpl.CustomerServiceImpl;
import com.myproject.connections.serviceimpl.StatesServiceImpl;
import com.myproject.connections.utility.CustomerResource;

/**
 * @author acer
 *
 */
/**
 * @author acer
 *
 */
/**
 * @author acer
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {
	
	
	private static Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerServiceImpl customerService;
	
	@Autowired
	StatesServiceImpl stateService;
	
	@Autowired
	private CustomerResource resource;
	

	@Autowired
	private CustDetailsRepository custDetailsRepository;

	
	@PostMapping("/api/signup")
	public MessageBean signUpCustomer(@RequestBody @Valid CustomerDetails customerDetails,BindingResult bindingResult){
		logger.info("Validating customer details");
		if(bindingResult.hasErrors()) {
		logger.info("Server error: Invalid Customer details,returning server error in the front end");
	    	String message = bindingResult.getFieldError().getDefaultMessage();
	    	MessageBean bean = new MessageBean();
	    	bean.setError(message);
	    	 return bean;
	    	 
	    }
		
		logger.info("Saving Customer Data in the database");
		 logger.info("Calling CustomerServiceImpl to save Customer Data");
	    customerService.saveUser(customerDetails);
	    return new MessageBean();
	}
	
	/*End Point to update Customer data in the database
	 *@param customerDetails model
	 *@param bindingResults containing errors when validation fails
	 *@return messageBean contains server errors if any after server validation
	 */
	@PatchMapping("/api/updateProfile")
	public MessageBean updateCustomer(@RequestBody CustomerModel customerDetails,BindingResult bindingResult){
		logger.info("Validating customer details for updating Customer Profile");

		AddressEntity address = new AddressEntity(customerDetails.getStreet(),
				customerDetails.getHouseNumber(),customerDetails.getLandMark(),
				customerDetails.getCity(),customerDetails.getState());

		CustomerDetails customerSql = new CustomerDetails();
		customerSql.setAddressEntity(address);
		customerSql.setName(customerDetails.getName());
		customerSql.setEmailid(customerDetails.getEmailid());

		customerService.updateUser(customerSql);

		logger.info("Updating Customer Data in the database");
		logger.info("Calling CustomerServiceImpl to update Customer Data");
		return new MessageBean();
	}
	
	
//shreya code for Hateos//
	@GetMapping("/api/getCustomer/{emailId}")
	 public ResponseEntity<CustomerModel> getCustomer(@PathVariable final String
	 emailId) {
	   return custDetailsRepository.findById(emailId)
			   .map(resource::toModel)
			   .map(ResponseEntity::ok)
			   .orElse(ResponseEntity.notFound().build());	
	 }
	 
	
	
	
	
	/* Note: using getters and setters only for mockito*/
	
	public CustomerServiceImpl getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerServiceImpl customerService) {
		this.customerService = customerService;
	}


}
