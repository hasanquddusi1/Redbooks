package frontcontroller;

import io.javalin.Javalin;
import io.javalin.core.util.Header;

public class FrontController {
	Javalin app;
	Dispatcher dispatcher;
	
	public FrontController(Javalin app) {
		this.app = app; 
		this.dispatcher = new Dispatcher(app);
	}
}
