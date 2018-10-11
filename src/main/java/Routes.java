import Servicios.JsonTransformer;

import java.io.File;

import static spark.Spark.*;

public class Routes {
	private static final String API_CONTEXT = "/";


	public Routes() {
		setupEndpoints();
	}

	private void setupEndpoints() {
        get(API_CONTEXT +"/pepe", "application/json", (request, response)

                -> new File("C:\\Users\\nicox\\Workspace\\2018-jm-group-10\\src\\main\\resources\\public\\index.html"), new JsonTransformer());

    }
}