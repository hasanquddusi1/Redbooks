package frontcontroller;

import controllers.BookController;
import io.javalin.Javalin;
import io.javalin.core.util.Header;
import controllers.CustomerController;
import controllers.ManagerController;



public class Dispatcher {
	public Dispatcher(Javalin app) {
//		GET, PUT localhost:5000/red-books/dashboard/edit -> edit account details
//      GET, PUT localhost:5000/red-books/admin/dashboard/edit -> edit account details
//		and GET, POST localhost:5000/red-books/books-view -> View All Books
		
	    
		app.post("/red-books/login", CustomerController::verifyCustomer);
		app.get("/api/red-books/books-view", BookController::getAllBooks);
		app.post("/api/red-books/books-view", BookController::getOneBook);	
		//app.post("/red-books/dashboard/edit", CustomerController::viewAccount);
		app.post("/red-books/dashboard/edit", CustomerController::editAccount);
		app.post("/red-books/admin/dashboard/edit", ManagerController::viewAccount);
		app.put("/red-books/admin/dashboard/edit", ManagerController::editAccount);
		app.post("/red-books/dashboard/search", BookController::searchByGenre);
		/*
		 * This is where we are going to delegate where the requests go
		 * 
		 *
		 */
		app.post("/red-books/create", CustomerController::createAccount);
		app.get("/red-books/dashboard-admin/list-all-customers",ManagerController::getCustomerList);
		app.put("/red-books/dashboard-admin/delete-account/:id", ManagerController::deleteCustomer);
	}
}
