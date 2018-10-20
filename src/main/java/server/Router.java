package server;

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
		
		
		Spark.get("/",LoginController::login,engine);
		
		//Spark.post("/login", LoginController::login, engine);
		//Spark.get("/proyectos", proyectosController::listar, engine);
		//Spark.get("/proyectos/new", proyectosController::nuevo, engine);
		//Spark.get("/proyectos/:id", proyectosController::mostrar, engine);
		//Spark.post("/proyectos", proyectosController::crear);
	}

}