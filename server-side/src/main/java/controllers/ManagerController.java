package controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import io.javalin.http.Context;

import services.ManagerService;
import services.ManagerServiceImpl;

public class ManagerController {
	static ManagerService managerService = new ManagerServiceImpl();
	
	//get customers list for manager dashboard
	public static void getCustomerList(Context context) {
		context.json(managerService.getCustomerList());
		
	}
	
	//delete customers from manager dashboard
	public static void deleteCustomer(Context context) {
		Integer key = Integer.parseInt(context.pathParam("id"));
		managerService.deleteCustomer(key);
	}

	
	public static void viewAccount(Context context) {
		String body = context.body();
		JsonObject convertedObject = new Gson().fromJson(body, JsonObject.class);
		int key = convertedObject.get("admin_id").getAsInt();
		context.json(managerService.getOne(key));
	}
	
	public static void editAccount(Context context) {
		String body = context.body();
		JsonObject convertedObject = new Gson().fromJson(body, JsonObject.class);
		String str = "";
		boolean check = false;
		int id = convertedObject.get("admin_id").getAsInt();
		try {
			check = true;
			str = convertedObject.get("admin_password").getAsString();
		}
		catch(Exception e){
			check = false;
			str = convertedObject.get("admin_username").getAsString();
		}
	
		if(check) {
			managerService.changePassword(id, str);
		}
		else {
			managerService.changeUsername(id, str);
		}
	}
}
