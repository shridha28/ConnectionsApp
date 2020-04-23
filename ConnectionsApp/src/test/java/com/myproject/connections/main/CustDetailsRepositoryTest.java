package com.myproject.connections.main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.myproject.connections.entitybeans.AddressEntity;
import com.myproject.connections.entitybeans.CustomerEntity;
import com.myproject.connections.main.ConnectionsAppApplication;
import com.myproject.connections.repository.CustDetailsRepository;
import com.myproject.connections.security.controller.PasswordController;
import com.myproject.connections.security.serviceimpl.PasswordSecurityServiceImpl;
import com.myproject.connections.serviceimpl.EmailServiceImpl;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {EmailServiceImpl.class, PasswordSecurityServiceImpl.class,PasswordController.class})
@DataJpaTest
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
		CustomerEntity cust = new CustomerEntity(null,"abc","abc@gmail.com", adress,null, null, "ddd");
				repo.save(cust);
		CustomerEntity custByEmail = repo.findByEmailid("abc@gmail.com");
		Assert.assertEquals(custByEmail.getName(),"abc");
		
		
	}
	
	/*@Test    
	public void it_should_save_user() {        
		CustomerEntity user = new CustomerEntity(null,"abc","abc@gmail.com", null,null, null, "ddd");   
		//user = testEntityManager.persistAndFlush(user);
		Assert.assertEquals(repo.findByEmailid(user.getEmailid()),user);    
		}*/

}
