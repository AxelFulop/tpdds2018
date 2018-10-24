package controllers;

import java.util.HashMap;
import java.util.List;

import Servicios.UsuarioService;
import modelo.Cliente;
import modelo.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;



public class AdministradorController {

	public static ModelAndView home(Request req, Response res){
		try {

			HashMap<String, Object> viewModel = new HashMap<>();
			Usuario admin = UsuarioService.obtenerUsuarioPorId(Long.parseLong(req.cookie("userId")));
			if(admin!=null) {
				viewModel.put("name", admin.getNombre());
				viewModel.put("id", admin.getId());
			}
			return new ModelAndView(viewModel, "adminDash.hbs");
		}catch (Exception e)
		{
			return new ModelAndView(null, "statusCodePages/404.hbs");
		}
	}
	public static ModelAndView dispositivo(Request req, Response res){
		Usuario admin = UsuarioService.obtenerUsuarioPorId(Long.parseLong(req.cookie("userId")));
			HashMap<String, Object> viewModel = new HashMap<>();
			viewModel.put("name",admin.getNombre());
			viewModel.put("id",admin.getId());
			return new ModelAndView(viewModel,"admin/crearDispositivo.hbs");
	}

	public static ModelAndView obtenerHogares(Request req, Response res){
		try {
			HashMap<String, Object> viewModel = new HashMap<>();
			Usuario admin = UsuarioService.obtenerUsuarioPorId(Long.parseLong(req.cookie("userId")));
			List<Cliente> clientes = UsuarioService.obtenerHogares();
			viewModel.put("cliente",clientes);
			return new ModelAndView(viewModel,"admin/hogares.hbs");
		}catch (Exception e)
		{
			return new ModelAndView(null, "statusCodePages/404.hbs");
		}
	}

}


