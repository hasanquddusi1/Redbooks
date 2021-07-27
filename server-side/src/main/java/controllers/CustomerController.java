package controllers;


import com.google.gson.Gson;
import com.google.gson.JsonObject;

import io.javalin.http.Context;
import models.Customer;
import services.CustomerService;
import services.CustomerServiceImpl;
public class CustomerController {
	static CustomerService customerService = new CustomerServiceImpl();
	public static void verifyCustomer(Context context) {

		
		String username = context.formParam("customer_username");
		String password = context.formParam("customer_password");
		Customer customer = new Customer();
		customer.setCustomerUserName(username);
		customer.setCustomerPassword(password);

		if (customerService.verifyCustomerCredentials(customer)){
			context.redirect("https://therealredbook.s3.us-east-2.amazonaws.com/html/user_dashboard.html");
		}
		else {
			context.redirect("https://therealredbook.s3.us-east-2.amazonaws.com/html/login.html");
		}
	}

	
	public static void createAccount(Context context) {
		Customer customer = context.bodyAsClass(Customer.class);
		customerService.createAccount(customer);
		context.redirect("https://therealredbook.s3.us-east-2.amazonaws.com/html/login.html");
	}
	
	public static void viewAccount(Context context) {
		String body = context.body();
		JsonObject convertedObject = new Gson().fromJson(body, JsonObject.class);
		int key = convertedObject.get("customer_id").getAsInt();
		context.json(customerService.getOne(key));
	}
	
	
	
	public static void editAccount(Context context) {
		String body = context.body();
		JsonObject convertedObject = new Gson().fromJson(body, JsonObject.class);
		String str = "";
		boolean check = false;
		int id = convertedObject.get("customer_id").getAsInt();
		try {
			check = true;
			str = convertedObject.get("customer_password").getAsString();
		}
		catch(Exception e){
			check = false;
			str = convertedObject.get("customer_username").getAsString();
		}
	
		if(check) {
			customerService.changePassword(id, str);
		}
		else {
			customerService.changeUsername(id, str);
		}
	}
	
	

}
