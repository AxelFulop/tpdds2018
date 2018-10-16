import Servicios.JsonTransformer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import modelo.Usuario;

import java.io.File;
import java.text.Normalizer;
import java.util.HashMap;

import static spark.Spark.*;

public class Routes {
	private static final String API_CONTEXT = "/api";


	public Routes() {
		setupEndpoints();
	}

	private void setupEndpoints() {
        post(API_CONTEXT + "/authenticate" , "application/json", (request, response)
                -> {

			JsonElement root = new JsonParser().parse(request.body());
			String user = root.getAsJsonObject().get("nombreUsuario").getAsString();
			String password = root.getAsJsonObject().get("contrasenia").getAsString();

			if (user!="" && password!="") {

				response.status(200);
			}
			else
				response.status(400);
			return response;
		}, new JsonTransformer());

    }
}