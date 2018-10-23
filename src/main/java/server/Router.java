package server;


import java.util.Map;


import modelo.Usuario;
import Servicios.UsuarioService;
import controllers.AdministradorController;
import controllers.ClientesController;
import controllers.HomeController;
import controllers.LoginController;
import setup.BooleanHelper;
import setup.HandlebarsTemplateEngineBuilder;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Router {

    public static void configure() {
        HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .build();

        Spark.staticFileLocation("/public");


        Spark.get("/", HomeController::home, engine);

        Spark.get("/loginFailed", LoginController::loginfailed, engine);
        Spark.get("/login", LoginController::show, engine);
        Spark.post("/login", (req, res) -> new LoginController(req, res).login());
        Spark.get("/logout", (req, res) -> new LoginController(req, res).logout());


        Spark.get("/clientes/:id", ClientesController::home, engine);
        Spark.get("/clientes/:id/hogar", ClientesController::mostrarEstadoHogar, engine);
        Spark.get("/clientes/:id/optimizador", ClientesController::mostrarSimplex, engine);
        Spark.get("/clientes/:id/consumo", ClientesController::getConsumo, engine);
        Spark.post("/clientes/:id/consumo",(req, res) -> new ClientesController().postConsumo(req, res));
        
        
        
        Spark.get("/administrador/:id", AdministradorController::home, engine);
        Spark.get("/administrador/:id/dispositivo", AdministradorController::dispositivo, engine);

    }

}