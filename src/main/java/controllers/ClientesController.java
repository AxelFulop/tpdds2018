package controllers;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.math3.optim.linear.NoFeasibleSolutionException;

import com.google.gson.Gson;

import Servicios.Session;
import Servicios.UsuarioService;
import modelo.Cliente;
import modelo.Dispositivo;
import modelo.DispositivoInteligente;
import modelo.Optimizador;
import modelo.Sensor;
import reportes.GeneradorReportes;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ClientesController {
	
	private static Cliente obtenerCliente(Request req, Response res) {
		Long idCliente = Long.parseLong(req.params("id"));	
		Cliente cliente = UsuarioService.obtenerClientePorId(idCliente);
		return cliente;
	}
	
	public static ModelAndView home(Request req, Response res){	
		Cliente cliente = UsuarioService.obtenerClientePorId( Long.valueOf(req.cookie("userId")) );
	
		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("nombre", cliente.getNombre());
		viewModel.put("apellido",cliente.getApellido());
		viewModel.put("id",cliente.getId());
		return new ModelAndView(viewModel,"home/homeCliente.hbs");
	}

	
	public static ModelAndView  mostrarEstadoHogar(Request req, Response res){
		Cliente cliente = obtenerCliente(req, res);
		List<DispositivoInteligente> dispI = UsuarioService.obtenerDispositivosInteligentesPorId(cliente.getId());
		List<Sensor> sensores = UsuarioService.obtenerSensoresPorId(cliente.getId());
		
		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("nombre", cliente.getNombre());
		viewModel.put("apellido",cliente.getApellido());
	    viewModel.put("consumoUltimoMes",String.format("%.2f", GeneradorReportes.getReportePorHogar(cliente, LocalDate.now().minusMonths(1), LocalDate.now()) ));
		viewModel.put("dispositivosI", dispI);
		if(sensores.size() == 0) {
			viewModel.put("ultimaMedicion", null );
		}else {
			viewModel.put("ultimaMedicion", sensores.get(sensores.size()-1).getMedicion() );
		}

		return new ModelAndView(viewModel,"cliente/estadoHogarCliente.hbs");
	}
	
	public static ModelAndView  mostrarSimplex(Request req, Response res){
		Cliente cliente = obtenerCliente(req, res);	
		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("id", cliente.getId());
		return new ModelAndView(viewModel,"cliente/EjecucionSimplexCliente.hbs");
	}
	
	public static ModelAndView  mostrarSimplexFailed(Request req, Response res){
		Cliente cliente = obtenerCliente(req, res);	
		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("idCliente", cliente.getId());
		return new ModelAndView(viewModel,"cliente/EjecucionSimplexClienteFailed.hbs");
	}
	
	public static ModelAndView postSimplex(Request req, Response res) {
		Cliente cliente = obtenerCliente(req, res);	
		List<Dispositivo> dispositivos = UsuarioService.obtenerDispositivosPorId(cliente.getId());
        
		Double limiteMensual = Double.valueOf( req.queryParams("limiteMensual") );
		Optimizador optimizador = new Optimizador();
		List<Dispositivo> dispositivosOptimizables = optimizador.obtenerDispositivosOptimizables(dispositivos);
		try {
			List<Double> valoresOptimizados = optimizador.optimizar(dispositivos, limiteMensual);
		
			List<DuplaDispositivoValorOptimizado> listaDuplas = new ArrayList<DuplaDispositivoValorOptimizado>();
			for(int i = 0; i < dispositivosOptimizables.size(); i++) {
				DuplaDispositivoValorOptimizado dupla = new DuplaDispositivoValorOptimizado(dispositivosOptimizables.get(i).getNombre(), valoresOptimizados.get(i));
				listaDuplas.add(dupla);
			}	
		
			HashMap<String, Object> viewModel = new HashMap<>();
			viewModel.put("valoresOptimizados", listaDuplas);
			return new ModelAndView(viewModel,"cliente/EjecucionSimplexCliente.hbs");
		}catch(NoFeasibleSolutionException e) {
			res.redirect("/clientes/"+ cliente.getId() +"/optimizadorFailed");
			return null;
		}
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
		if(consumo < 0) {
			return new ModelAndView(viewModel,"cliente/consultaConsumoClienteFailed.hbs");
		}else {
			viewModel.put("inicio", req.queryParams("inicioPeriodo"));
			viewModel.put("fin", req.queryParams("finPeriodo"));
			viewModel.put("consumo", String.format("%.2f", consumo));
			return new ModelAndView(viewModel,"cliente/consultaConsumoCliente.hbs");
		}
	}
	
	public static String registrarMedicion(Request req, Response res) {
		Double medicion = Double.valueOf( req.queryParams("medicion") );
		Long idCliente = Long.valueOf( req.queryParams("idCliente") );

		List<Sensor> sensores = UsuarioService.obtenerSensoresPorId(idCliente);
		if( sensores != null ) {
			for(Sensor s: sensores) {
				s.setMedicion(medicion);
				s.tomarMedicion();
				s.persistir();
			}
			res.status(200);
		}
		else {
			res.status(404);
		}
		return "";
	}
	
	public static String getEstadoDispositivo(Request req, Response res) {
		Long idCliente = Long.valueOf( req.queryParams("idCliente") );
		Long idDispositivo = Long.valueOf( req.queryParams("idDispositivo") );
		
		DispositivoInteligente disp = UsuarioService.obtenerDispositivoInteligenteDelClientePorId(idCliente, idDispositivo);
		
		if( disp != null ) {
		    res.header("estado", disp.getEstado().toString());
			res.status(200);		
		}
		else {
			res.status(404);
		}

		return "";
	}
	
	public static String getConsumoDispositivo(Request req, Response res) {
		Long idCliente = Long.valueOf( req.queryParams("idCliente") );
		Long idDispositivo = Long.valueOf( req.queryParams("idDispositivo") );
		
		DispositivoInteligente disp = UsuarioService.obtenerDispositivoInteligenteDelClientePorId(idCliente, idDispositivo);
		
		if( disp != null ) {
		    res.header("consumo", disp.getConsumoMensual().toString());
			res.status(200);	
		}
		else {
			res.status(404);
		}

		return "";
	}
	
	public static String encenderDispositivo(Request req, Response res) {
		Long idCliente = Long.valueOf( req.queryParams("idCliente") );
		Long idDispositivo = Long.valueOf( req.queryParams("idDispositivo") );
		
		DispositivoInteligente disp = UsuarioService.obtenerDispositivoInteligenteDelClientePorId(idCliente, idDispositivo);
		
		if( disp != null ) {
			disp.encender();
			disp.persistir();
			res.status(200);
		}
		else {
			res.status(404);
		}
		return "";
	}
	
	public static String apagarDispositivo(Request req, Response res) {
		Long idCliente = Long.valueOf( req.queryParams("idCliente") );
		Long idDispositivo = Long.valueOf( req.queryParams("idDispositivo") );
		
		DispositivoInteligente disp = UsuarioService.obtenerDispositivoInteligenteDelClientePorId(idCliente, idDispositivo);
		
		if(disp != null) {
			disp.apagar();
			disp.persistir();
			res.status(200);
		}
		else {
			res.status(404);
		}
		return "";
	}
	
	public static String getDispositivosInteligentes(Request req, Response res) {
		Long idCliente = Long.valueOf( req.queryParams("idCliente") );
		List<DispositivoInteligente> disp = UsuarioService.obtenerDispositivosInteligentesPorId(idCliente);
		try {
			Gson gson = new Gson(); 
			String jsonDispositivos = gson.toJson(disp);
			res.status(200);
			return jsonDispositivos;
		}catch(Exception e) {
			e.printStackTrace();
			res.status(404);
			return "";
		}	
	}
	
}