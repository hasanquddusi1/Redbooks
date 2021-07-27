package services;

import models.Book;
import models.Customer;


public interface CustomerService {
	
   boolean verifyCustomerCredentials(Customer customer);
   	
   
   
   /*
    * Create new account for customer
    */
   void createAccount(Customer customer);

   
   Customer getOne(int key);
   
   void changePassword(int id, String password);
   void changeUsername(int id, String username);

}


