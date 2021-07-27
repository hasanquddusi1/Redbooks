package services;
import java.util.Map;

import models.Customer;
import models.Manager;

public interface ManagerService {
	Map<Integer, Customer> getCustomerList();
	void deleteCustomer(Integer key);
	Manager getOne(int key);
	void changePassword(int id, String str);
	void changeUsername(int id, String str);
	
}
