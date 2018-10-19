import Servicios.JsonTransformer;
import Servicios.UsuarioService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import modelo.Usuario;


import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static spark.Spark.*;

public class Controller {
    private static final String API_CONTEXT = "/api";


    public Controller() {
        setupEndpoints();
    }

    private void setupEndpoints() {
        post(API_CONTEXT + "/authenticate", "application/json", (request, response)
                -> {
            try {
                JsonElement root = new JsonParser().parse(request.body());
                String userName = root.getAsJsonObject().get("nombreUsuario").getAsString();
                String password = root.getAsJsonObject().get("contrsenia").getAsString();
                Usuario user = UsuarioService.obtenerUsuario(userName, password);
                if (user != null) {
                    response.status(200);
                    response.redirect("/api/main");
                    return response;
                }

            } catch (Exception e) {
                response.status(500);
            }
            return response;

        });
        get(API_CONTEXT + "/main", "application/json", (request, response)
                -> {
            return renderContent("public/main.html");
        });


    }
    private String renderContent(String htmlFile) {
        try {
            // If you are using maven then your files
            // will be in a folder called resources.
            // getResource() gets that folder
            // and any files you specify.
            URL url = getClass().getResource(htmlFile);

            // Return a String which has all
            // the contents of the file.
            Path path = Paths.get(url.toURI());
            return new String(Files.readAllBytes(path), Charset.defaultCharset());
        } catch (IOException | URISyntaxException e) {
            // Add your own exception handlers here.
        }
        return null;
    }

}