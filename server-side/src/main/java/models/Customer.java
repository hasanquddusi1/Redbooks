package models;

public class Customer {
	private int customerID;
	private String customerUserName;
	private String customerPassword;

	public Customer() {
		super();
	}

	public Customer(int customerid, String username, String password) {
		super();
		this.setCustomerUserName(username);
		this.setCustomerPassword(password);
		this.setCustomerID(customerid);
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerUserName() {
		return customerUserName;
	}

	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

}
