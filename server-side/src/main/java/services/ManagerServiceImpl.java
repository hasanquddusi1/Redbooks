package services;

import java.util.Map;

import dao.ManagerDashDao;
import dao.ManagerDashDaoImpl;
import models.Customer;
import models.Manager;

public class ManagerServiceImpl implements ManagerService{
	
	ManagerDashDao managerDashDao;
	
	public ManagerServiceImpl() {
		this.managerDashDao = new ManagerDashDaoImpl();
	}

	@Override
	public Map<Integer, Customer> getCustomerList() {
		return this.managerDashDao.getCustomerList();
	}

	@Override
	public void deleteCustomer(Integer key) {
		this.managerDashDao.deleteCustomer(key);
		
	}

	@Override
	public Manager getOne(int key) {
		return this.managerDashDao.getOne(key);
	}

	@Override
	public void changePassword(int id, String str) {
		this.managerDashDao.changePassword(id, str);
	}

	@Override
	public void changeUsername(int id, String str) {
		this.managerDashDao.changeUsername(id, str);
	}

}
