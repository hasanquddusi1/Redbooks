package driver;

import frontcontroller.FrontController;
import io.javalin.Javalin;
import io.javalin.core.util.Header;

public class Main {

	public static void main(String[] args) {
		
		Javalin app = Javalin.create(config -> {
			config.enableCorsForAllOrigins();
		}).start(5000);
		
		
		FrontController fc = new FrontController(app);

	}

}
