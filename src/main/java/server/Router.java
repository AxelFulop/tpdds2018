package server;

import controllers.AdministradorController;
import controllers.ClientesController;
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
        
        Spark.get("/loginFailed", LoginController::loginfailed, engine);
        Spark.get("/", LoginController::show, engine);
        Spark.post("/login", (req, res) -> new LoginController(req, res).login());
        Spark.get("/logout", (req, res) -> new LoginController(req, res).logout());

        Spark.get("/clientes/:id/hogar", ClientesController::mostrarEstadoHogar, engine);
        Spark.get("/clientes/:id/optimizador", ClientesController::mostrarSimplex, engine);
        Spark.get("/clientes/:id/optimizadorFailed", ClientesController::mostrarSimplexFailed, engine);
        Spark.post("/clientes/:id/optimizador", ClientesController::postSimplex, engine);
        Spark.get("/clientes/:id/consumo", ClientesController::getConsumo, engine);
        Spark.post("/clientes/:id/consumo", ClientesController::postConsumo, engine);

        Spark.get("/administrador/:id", AdministradorController::home, engine);

        Spark.get("/administrador/:id/hogares",AdministradorController::obtenerHogares,engine);
        Spark.get("/administrador/:id/dispositivos", AdministradorController::obtenerDispositivos,engine);

        Spark.post("/administrador/:id/dispositivos/dispositivoInteligente", (req, res) -> new AdministradorController(req,res).crearDispositivoInteligente());
        Spark.post("/administrador/:id/dispositivos/dispositivoEstandar", (req, res) -> new AdministradorController(req,res).crearDispositivoEstandar());

        Spark.get("/administrador/:id/hogares/reportes", AdministradorController::generarReporteHogar,engine);
        
        Spark.post("/sensor", ClientesController::registrarMedicion);
        
        Spark.get("/dispositivo/estado", ClientesController::getEstadoDispositivo);
        Spark.get("/dispositivo/consumo", ClientesController::getConsumoDispositivo);
        Spark.post("/dispositivo/encender", ClientesController::encenderDispositivo);
        Spark.post("/dispositivo/apagar", ClientesController::apagarDispositivo);
        Spark.get("/dispositivosInteligentes", ClientesController::getDispositivosInteligentes);
        
    }

}
