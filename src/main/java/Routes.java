import Servicios.JsonTransformer;

import java.io.File;

import static spark.Spark.*;

public class Routes {
	private static final String API_CONTEXT = "/api";


	public Routes() {
		setupEndpoints();
	}

	private void setupEndpoints() {
        post(API_CONTEXT + "/authenticate" , "application/json", (request, response)
                -> {
			String a = request.body();
			response.status(200);
			return response;
		}, new JsonTransformer());

    }
}