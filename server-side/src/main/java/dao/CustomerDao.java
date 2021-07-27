package dao;

import models.Book;
import models.Customer;


public interface CustomerDao {
	
	
	/*
	 * To verify customer login credentials
	 */
	boolean verifyCustomerCredentials(String username, String password);
	
	
	/*
	 * Create a new account for customers
	 */
	void createAccount(Customer customer);
	
	Customer getOne(int key);
	
	void changePassword(int id, String password);
	
	void changeUsername(int id, String username);

}
