package controllers;

import spark.ModelAndView;
import spark.Response;
import spark.Request;
 
public class MapaController {
	
	public static ModelAndView home(Request req,Response res){
		return new ModelAndView(null,"mapa/mapa.hbs");
	}
}