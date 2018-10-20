package controllers;

import java.util.HashMap;

import Servicios.UsuarioService;
import modelo.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ClientesController {
	public static ModelAndView home(Request req, Response res){
		Long idCliente = Long.parseLong(req.params("id"));	
		Usuario cliente = UsuarioService.obtenerUsuarioPorId(idCliente);
		
		//cliente de prueba (ANDA)
		//Cliente cliente = new Cliente("lucas","rosol",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","luqui","asd",0);
		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("nombre", cliente.getNombre());
		viewModel.put("apellido",cliente.getApellido());
		return new ModelAndView(viewModel,"home/homeCliente.hbs");
	}
}
