package com.myproject.connections.test.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.myproject.connections.entitybeans.AddressEntity;
import com.myproject.connections.entitybeans.CustomerEntity;
import com.myproject.connections.entitybeans.Role;
import com.myproject.connections.main.ConnectionsAppApplication;
import com.myproject.connections.repository.CustDetailsRepository;
import com.myproject.connections.serviceimpl.CustomerServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConnectionsAppApplication.class)
public class CustomerServiceImplTest {
	
	@Autowired
	CustomerServiceImpl serviceImpl;
	
	
	@MockBean
	CustDetailsRepository repo;
	
	
	@MockBean
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@BeforeEach 
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void create_Customer_Shud_CreateAUserWithRole() throws Exception{
    Role role = new Role(1001,"user", null, null);
    Set<Role> roles = new HashSet<>();
    roles.add(role);
		CustomerEntity cust = new CustomerEntity(null,"abc@gmail.com", "ddd",null, roles,null,null);
		
		 
		Mockito.when(repo.save(cust)).thenReturn(cust);
		CustomerEntity customer =serviceImpl.saveCustomer(cust);
		Assert.assertEquals(cust , customer);
	}
	
	/*@Test
	void update_customer_test() throws Exception{
	    
		AddressEntity adress = new AddressEntity("street","11-6","mark the land","city","state");
		CustomerEntity cust = new CustomerEntity(null,"abc@gmail.com","ddd","abc",null, null, adress);
		Mockito.when(repo.findByEmailid(cust.getEmailid())).thenReturn(cust);
		CustomerEntity custUpdate = cust;
		custUpdate.setAddressEntity(cust.getAddressEntity());
		custUpdate.setName(cust.getName());
		Mockito.when(repo.save(custUpdate)).thenReturn(cust);
		CustomerEntity customer =serviceImpl.updateUser(cust);
		Assert.assertEquals(customer , custUpdate);
		
	}*/
	@Test
	void get_customerByEmailId_test() throws Exception{
		String emailId = "abc@gmail.com";
		AddressEntity adress = new AddressEntity("street","11-6","mark the land","city","state");
		CustomerEntity cust = new CustomerEntity(null,"abc@gmail.com","ddd","abc", null, null,adress);
		Mockito.when(repo.findByEmailid(emailId)).thenReturn(cust);
		CustomerEntity customerService = serviceImpl.getCustomer(emailId);
		Assert.assertEquals(cust , customerService);
		
	}

}

