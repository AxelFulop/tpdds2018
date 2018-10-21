package controllers;

import java.util.HashMap;

import Servicios.UsuarioService;
import modelo.Cliente;
import modelo.TipoIdentificacion;
import modelo.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ClientesController {
	private static Usuario obtenerUsuario(Request req, Response res) {
		Long idCliente = Long.parseLong(req.params("id"));	
		Usuario cliente = UsuarioService.obtenerUsuarioPorId(idCliente);
		return cliente;
	}
	
	public static ModelAndView home(Request req, Response res){	
		Usuario cliente = obtenerUsuario(req, res);
		
		//cliente de prueba (ANDA)
		//Cliente cliente = new Cliente("lucas","rosol",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","luqui","asd",0);
		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("nombre", cliente.getNombre());
		viewModel.put("apellido",cliente.getApellido());
		viewModel.put("idCliente",cliente.getId());
		return new ModelAndView(viewModel,"home/homeCliente.hbs");
	}

	
	public static ModelAndView  mostrarEstadoHogar(Request req, Response res){
		Usuario cliente = obtenerUsuario(req, res);
		
		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("nombre", cliente.getNombre());
		viewModel.put("apellido",cliente.getApellido());
		viewModel.put("idCliente", cliente.getId());
		return new ModelAndView(viewModel,"home/estadoHogarCliente.hbs");
	}
	
	public static ModelAndView  mostrarSimplex(Request req, Response res){
		Usuario cliente = obtenerUsuario(req, res);
		
		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("nombre", cliente.getNombre());
		viewModel.put("apellido",cliente.getApellido());
		viewModel.put("idCliente", cliente.getId());
		return new ModelAndView(viewModel,"home/EjecucionSimplexCliente.hbs");
	}
	
	public static ModelAndView  mostrarConsumo(Request req, Response res){
		Usuario cliente = obtenerUsuario(req, res);
		
		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("nombre", cliente.getNombre());
		viewModel.put("apellido",cliente.getApellido());
		viewModel.put("idCliente", cliente.getId());
		return new ModelAndView(viewModel,"home/consultaConsumoCliente.hbs");
	}
}
