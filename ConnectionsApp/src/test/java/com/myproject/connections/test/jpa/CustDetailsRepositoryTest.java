package com.myproject.connections.test.jpa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.myproject.connections.entitybeans.AddressEntity;
import com.myproject.connections.entitybeans.CustomerEntity;
import com.myproject.connections.main.ConnectionsAppApplication;
import com.myproject.connections.repository.CustDetailsRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=ConnectionsAppApplication.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class CustDetailsRepositoryTest {
	

	@Autowired
	 CustDetailsRepository repo;
	
	
	@Before
    public void setUp(){
		MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void get_customer_test() throws Exception{
		AddressEntity adress = new AddressEntity("street","11-6","mark the land","city","state");
		CustomerEntity cust = new  CustomerEntity(null,"abc@gmail.com","abc", "abc", null, null, adress);
				repo.save(cust);
		CustomerEntity custByEmail = repo.findByEmailid("abc@gmail.com");
		Assert.assertEquals(custByEmail.getName(),"abc");
		
		
	}
	
	

}
