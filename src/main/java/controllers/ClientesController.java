package controllers;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Servicios.UsuarioService;
import modelo.Cliente;
import modelo.Dispositivo;
import modelo.DispositivoEstandar;
import modelo.DispositivoInteligente;
import modelo.Optimizador;
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
		Cliente cliente = obtenerCliente(req, res);
		
	
		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("nombre", cliente.getNombre());
		viewModel.put("apellido",cliente.getApellido());
		viewModel.put("id",cliente.getId());
		return new ModelAndView(viewModel,"home/homeCliente.hbs");
	}

	
	public static ModelAndView  mostrarEstadoHogar(Request req, Response res){
		Cliente cliente = obtenerCliente(req, res);
		List<DispositivoInteligente> dispI = UsuarioService.obtenerDispositivosInteligentes(cliente.getNombreUsuario(), cliente.getContrasena());
		
		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("nombre", cliente.getNombre());
		viewModel.put("apellido",cliente.getApellido());
		//viewModel.put("consumoUltimoMes",GeneradorReportes.getReportePorHogar(cliente, LocalDate.now().minusMonths(1), LocalDate.now()) );
		viewModel.put("dispositivosI", dispI);
		return new ModelAndView(viewModel,"cliente/estadoHogarCliente.hbs");
	}
	
	public static ModelAndView  mostrarSimplex(Request req, Response res){
		Cliente cliente = obtenerCliente(req, res);	
		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("id", cliente.getId());
		return new ModelAndView(viewModel,"cliente/EjecucionSimplexCliente.hbs");
	}
	
	public static ModelAndView postSimplex(Request req, Response res) {
		Cliente cliente = obtenerCliente(req, res);		
		List<Dispositivo> dispositivos = UsuarioService.obtenerDispositivos(cliente.getNombreUsuario(), cliente.getContrasena());
        
		Double limiteMensual = Double.valueOf( req.queryParams("limiteMensual") );
		Optimizador optimizador = new Optimizador();
		List<Double> valoresOptimizados = optimizador.optimizar(dispositivos, limiteMensual);
		
		List<DuplaDispositivoValorOptimizado> listaDuplas = new ArrayList<DuplaDispositivoValorOptimizado>();
		for(int i = 0; i < dispositivos.size(); i++) {
			DuplaDispositivoValorOptimizado dupla = new DuplaDispositivoValorOptimizado(dispositivos.get(i), valoresOptimizados.get(i));
			listaDuplas.add(dupla);
		}
		
		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("valoresOptimizados", listaDuplas);
		return new ModelAndView(viewModel,"cliente/EjecucionSimplexCliente.hbs");
	}
	
	public static ModelAndView  getConsumo(Request req, Response res){
		Cliente cliente = obtenerCliente(req, res);
		
		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("nombre", cliente.getNombre());
		viewModel.put("apellido",cliente.getApellido());
		viewModel.put("idCliente", cliente.getId());
		return new ModelAndView(viewModel,"cliente/consultaConsumoCliente.hbs");
	}
	
	public static ModelAndView  postConsumo(Request req, Response res){
		Cliente cliente = obtenerCliente(req, res);
		
		LocalDate inicio = LocalDate.parse(req.queryParams("inicioPeriodo"));
		LocalDate fin = LocalDate.parse(req.queryParams("finPeriodo"));
		Double consumo = GeneradorReportes.getReportePorHogar(cliente, inicio, fin);
		HashMap<String, Object> viewModel = new HashMap<>();
		
		viewModel.put("nombre", cliente.getNombre());
		viewModel.put("apellido",cliente.getApellido());
		viewModel.put("inicio", req.queryParams("inicioPeriodo"));
		viewModel.put("fin", req.queryParams("finPeriodo"));
		viewModel.put("consumo", consumo.toString());
		return new ModelAndView(viewModel,"cliente/consultaConsumoCliente.hbs");
	}
	
}