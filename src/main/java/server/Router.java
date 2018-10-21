package server;

import modelo.TipoIdentificacion;
import modelo.Usuario;
import controllers.AdministradorController;
import controllers.ClientesController;
import controllers.HomeController;
//import controllers.HomeController;
//import controllers.ProyectosController;
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
		Spark.staticFiles.expireTime(600L);
		
	     
		Spark.get("/",HomeController::home,engine);
		Spark.get("/Login",LoginController::show,engine);
		Spark.post("/Login", LoginController::login,engine);
		Spark.get("/Clientes/:id", ClientesController::home, engine);
		Spark.get("/Administradores/:id",AdministradorController::home, engine);
		
	}

}