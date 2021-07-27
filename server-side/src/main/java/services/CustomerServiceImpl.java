package services;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import models.Book;
import models.Customer;

public class CustomerServiceImpl implements CustomerService {
	CustomerDao customerDao;

	public CustomerServiceImpl() {
		this.customerDao = new CustomerDaoImpl();
	}

	@Override
	public boolean verifyCustomerCredentials(Customer customer) {
		return this.customerDao.verifyCustomerCredentials(customer.getCustomerUserName(), customer.getCustomerPassword());
	}

	@Override
	/*
	 * Create a new account for customers
	 */
	public void createAccount(Customer customer) {
		this.customerDao.createAccount(customer);

	}
	
	@Override
	public Customer getOne(int key) {
		return this.customerDao.getOne(key);
	}
	
	@Override
	public void changePassword(int id, String password) {
		this.customerDao.changePassword(id, password);
	}
	
	@Override
	public void changeUsername(int id, String username) {
		this.customerDao.changeUsername(id, username);
	}
}
