import Servicios.JsonTransformer;
import Servicios.UsuarioService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import modelo.Usuario;


import static spark.Spark.*;

public class Controller {
	private static final String API_CONTEXT = "/api";


	public Controller() {
		setupEndpoints();
	}

	private void setupEndpoints() {
        post(API_CONTEXT + "/authenticate" , "application/json", (request, response)
                -> {
        	try {
				JsonElement root = new JsonParser().parse(request.body());
				String userName = root.getAsJsonObject().get("nombreUsuario").getAsString();
				String password = root.getAsJsonObject().get("contrsenia").getAsString();
				Usuario user = UsuarioService.obtenerUsuario(userName,password);
				if(user!=null)
				{
					response.status(200);
					Gson gson = new Gson();
					String a = gson.toJson(user);
					response.body(a);

				}

        	}catch (Exception e)
			{
				response.status(500);
			}
		return response;

	}, new JsonTransformer());

    }
}