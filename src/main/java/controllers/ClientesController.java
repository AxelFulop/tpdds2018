package controllers;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import Servicios.UsuarioService;
import modelo.Cliente;
import modelo.TipoIdentificacion;
import modelo.Usuario;
import reportes.GeneradorReportes;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ClientesController {
	private static Usuario obtenerUsuario(Request req, Response res) {
		Long idCliente = Long.parseLong(req.params("id"));	
		Usuario cliente = UsuarioService.obtenerUsuarioPorId(idCliente);
		return cliente;
	}
	
	private static Cliente obtenerCliente(Request req, Response res) {
		Long idCliente = Long.parseLong(req.params("id"));	
		Cliente cliente = UsuarioService.obtenerClientePorId(idCliente);
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
		return new ModelAndView(viewModel,"views/estadoHogarCliente.hbs");
	}
	
	public static ModelAndView  mostrarSimplex(Request req, Response res){
		Usuario cliente = obtenerUsuario(req, res);
		
		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("nombre", cliente.getNombre());
		viewModel.put("apellido",cliente.getApellido());
		viewModel.put("idCliente", cliente.getId());
		return new ModelAndView(viewModel,"views/EjecucionSimplexCliente.hbs");
	}
	
	public static ModelAndView  getConsumo(Request req, Response res){
		Usuario cliente = obtenerUsuario(req, res);
		
		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("nombre", cliente.getNombre());
		viewModel.put("apellido",cliente.getApellido());
		
		return new ModelAndView(viewModel,"views/consultaConsumoCliente.hbs");
	}
	
	public static ModelAndView  postConsumo(Request req, Response res){
		Cliente cliente = obtenerCliente(req,res);
		
		LocalDate inicio = LocalDate.parse(req.queryParams("inicioPeriodo"));
		LocalDate fin = LocalDate.parse(req.queryParams("finPeriodo"));
		Double consumo = GeneradorReportes.getReportePorHogar(cliente, inicio, fin);
		HashMap<String, Object> viewModel = new HashMap<>();
		
		viewModel.put("nombre", cliente.getNombre());
		viewModel.put("apellido",cliente.getApellido());
		viewModel.put("inicio", req.queryParams("inicioPeriodo"));
		viewModel.put("fin", req.queryParams("finPeriodo"));
		viewModel.put("consumo", consumo.toString());
		return new ModelAndView(viewModel,"views/consultaConsumoCliente.hbs");
	}
	
}