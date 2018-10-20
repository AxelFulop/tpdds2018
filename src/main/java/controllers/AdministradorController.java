package controllers;

import java.util.HashMap;

import Servicios.UsuarioService;
import modelo.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;



public class AdministradorController {

	public static ModelAndView home(Request req, Response res){
		Long idAdministrador= Long.parseLong(req.params("id"));	
		Usuario admin = UsuarioService.obtenerUsuarioPorId(idAdministrador);
		
	
		//Administrador admin = new Administrador("root","root","Pedro","Fuentes",TipoIdentificacion.DNI,"123");
		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("nombre", admin.getNombre());
		viewModel.put("apellido",admin.getApellido());
		return new ModelAndView(viewModel,"home/homeAdministrador.hbs");
	}
}


