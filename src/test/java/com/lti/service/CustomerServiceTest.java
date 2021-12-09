package com.lti.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.lti.model.Customer;
import com.lti.repository.ProducerRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

	
	@MockBean
	private ProducerRepository repo;
	
	@Autowired 
	private CustomerService service;
	
	@Test
	public void createCustomer() {
		Customer c=new Customer();
		c.setId(121);
		c.setName("Test Customer");
		c.setAccountType("Saving Test");
		c.setAdress("Test Address");
		c.setAge("156");
		Mockito.when(repo.save(c)).thenReturn(c);
        assertThat(service.save(c)).isEqualTo(c);
	}
	
	@Test
	public void getByid() {
		Customer c=new Customer();
		c.setName("Test Customer");
		c.setAccountType("Saving Test");
		c.setAdress("Test Address");
		c.setAge("156");
		Mockito.when(repo.findOne(121)).thenReturn(c);
	    assertThat(service.getByid(121)).isEqualTo(c);
		
	}
	public Customer createObj() {
		Customer c=new Customer();
		c.setName("Test Customer");
		c.setAccountType("Saving Test");
		c.setAdress("Test Address");
		c.setAge("156");
		return c;
	}
	
	@Test
	public void DeleteTest() {		
	      repo.delete(121);
		verify(repo, times(1)).delete(121);
	}
	
	
	
	
}
