import Servicios.JsonTransformer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


import static spark.Spark.*;

public class Controller {
	private static final String API_CONTEXT = "/api";


	public Controller() {
		setupEndpoints();
	}

	private void setupEndpoints() {
        post(API_CONTEXT + "/authenticate" , "application/json", (request, response)
                -> {
			JsonElement root = new JsonParser().parse(request.body());
			String user = root.getAsJsonObject().get("nombreUsuario").getAsString();
			String password = root.getAsJsonObject().get("contrsenia").getAsString();

			if (user!="" && password!="") {

				response.status(200);
			}
			else
				response.status(400);
			return response;
		}, new JsonTransformer());

    }
}