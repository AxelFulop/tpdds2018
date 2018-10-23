package controllers;

import java.util.HashMap;

import Servicios.UsuarioService;
import modelo.Cliente;
import modelo.TipoIdentificacion;
import modelo.Usuario;
import reportes.GeneradorReportes;
import scala.Console;
import spark.ModelAndView;
import spark.Request;
import spark.Response;


public class ClientesController {
	private static Usuario obtenerUsuario(Request req, Response res) {
		Long idCliente = Long.parseLong(req.cookie("userId"));	
		Usuario cliente = UsuarioService.obtenerUsuarioPorId(idCliente);
		return cliente;
	}
	
	private static Cliente obtenerCliente(Request req, Response res) {
		Long idCliente = Long.parseLong(req.cookie("userId"));	
		Cliente cliente = UsuarioService.obtenerClientePorId(idCliente);
		return cliente;
	}

	public static ModelAndView home(Request req, Response res){	
		try{
		HashMap<String, Object> viewModel = new HashMap<>();
		Usuario cliente = obtenerUsuario(req, res);
		if (!cliente.equals(null)){
		viewModel.put("nombre", cliente.getNombre());
		viewModel.put("apellido",cliente.getApellido());
		viewModel.put("id", cliente.getId());
		}
		return new ModelAndView(viewModel,"home/homeCliente.hbs");
		}
		catch (Exception e)
		{
			return new ModelAndView(null, "statusCodePages/404.hbs");
		}
	}

	
	public static ModelAndView  mostrarEstadoHogar(Request req, Response res){
		Usuario cliente = obtenerUsuario(req, res);
		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("nombre", cliente.getNombre());
		viewModel.put("apellido",cliente.getApellido());
		return new ModelAndView(viewModel,"cliente/estadoHogarCliente.hbs");
	}
	
	public static ModelAndView  mostrarSimplex(Request req, Response res){
		Usuario cliente = obtenerUsuario(req, res);
		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("nombre", cliente.getNombre());
		viewModel.put("apellido",cliente.getApellido());
		return new ModelAndView(viewModel,"cliente/EjecucionSimplexCliente.hbs");
	}
	
	public static ModelAndView  getConsumo(Request req, Response res){
		Usuario cliente = obtenerUsuario(req, res);
		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("nombre", cliente.getNombre());
		viewModel.put("apellido",cliente.getApellido());
		
		return new ModelAndView(viewModel,"cliente/consultaConsumoCliente.hbs");
	}
	
	public static String  postConsumo(Request req, Response res){
		Cliente cliente = obtenerCliente(req,res);

		double cons = GeneradorReportes.getReportePromedioPorDispositivo(cliente);
		int per = Integer.parseInt(req.queryParams("periodo"));
		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("nombre", cliente.getNombre());
		viewModel.put("apellido",cliente.getApellido());
		viewModel.put("id",cliente.getId());
		viewModel.put("periodo",per);
		viewModel.put("consumo", cons);
		return null;
	
}
	
}
