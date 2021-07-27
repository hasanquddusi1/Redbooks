package testng;

import java.util.HashMap;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dao.CustomerDao;
import models.Book;
import models.Customer;
import services.CustomerServiceImpl;

public class TestCustomerService {
	@Mock
	public CustomerDao customerDaoImpl;
	
	@InjectMocks
	public CustomerServiceImpl customerServiceImpl;
	
	
	@BeforeClass
	public void beforeTestGetOne() {
		customerServiceImpl = new CustomerServiceImpl();
		
		MockitoAnnotations.initMocks(this);
		Mockito.when(customerServiceImpl.getOne(1)).thenReturn(new Customer(1, "testusername","password"));
	}
	
	@Test
	public void testGetCustomerUsername() {
		Customer retrievedCustomer = customerServiceImpl.getOne(1);
		Assert.assertEquals(retrievedCustomer.getCustomerUserName(), "testusername");
	}
	
	@Test
	public void testGetCustomerPassword() {
		Customer retrievedCustomer = customerServiceImpl.getOne(1);
		Assert.assertEquals(retrievedCustomer.getCustomerPassword(), "password");
	}
	
	@Test
	public void testGetCustomerReturn() {
		Customer retrievedCustomer = customerServiceImpl.getOne(1);
		Assert.assertNotEquals(retrievedCustomer, null);
	}
	
	
}
