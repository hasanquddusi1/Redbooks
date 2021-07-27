package testng;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dao.ManagerDashDaoImpl;
import models.Manager;
import services.ManagerServiceImpl;


public class TestManagerService {
	@Mock
	public ManagerDashDaoImpl managerDashDaoImpl;
	
	@InjectMocks
	public ManagerServiceImpl managerServiceImpl;
	
	
	@BeforeClass
	public void beforeTestGetOne() {
		managerServiceImpl = new ManagerServiceImpl();
		
		MockitoAnnotations.initMocks(this);
		Mockito.when(managerServiceImpl.getOne(1)).thenReturn(new Manager(1, "testusername","password"));
	}
	
	@Test
	public void testGetManagerUsername() {
		Manager retrievedCustomer = managerServiceImpl.getOne(1);
		Assert.assertEquals(retrievedCustomer.getManagerUsername(), "testusername");
	}
	
	@Test
	public void testGetManagerPassword() {
		Manager retrievedCustomer = managerServiceImpl.getOne(1);
		Assert.assertEquals(retrievedCustomer.getManagerPassword(), "password");
	}
	@Test
	public void testGetManagerReturn() {
		Manager retrievedCustomer = managerServiceImpl.getOne(1);
		Assert.assertNotEquals(retrievedCustomer, null);
	}
	
}
