package controllers;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import Servicios.DispositivoService;
import Servicios.Token;
import Servicios.UsuarioService;
import modelo.*;
import reportes.GeneradorReportes;
import spark.ModelAndView;
import spark.Request;
import spark.Response;


public class AdministradorController {

    private static Request request;
    private static Response response;

    public AdministradorController(Request req, Response res) {
        this.request = req;
        this.response = res;
    }

    public static ModelAndView home(Request req, Response res) {
        try {
            if (Token.isAuth(req.cookie("token"),req.params("id")))
            {
            HashMap<String, Object> viewModel = new HashMap<>();
            Usuario admin = UsuarioService.obtenerUsuarioPorId(Long.parseLong(req.cookie("userId")));
                viewModel.put("name", admin.getNombre());
                viewModel.put("id", admin.getId());
                viewModel.put("saludo", "hola");
                return new ModelAndView(viewModel, "adminDash.hbs");
            }else
                return new ModelAndView(null, "statusCodePages/404.hbs");
        } catch (Exception e) {
            return new ModelAndView(null, "statusCodePages/404.hbs");
        }
    }

    public static ModelAndView obtenerHogares(Request req, Response res) {
        try {
            if (Token.isAuth(req.cookie("token"),req.params("id")))
            {
            HashMap<String, Object> viewModel = new HashMap<>();
            Usuario admin = UsuarioService.obtenerUsuarioPorId(Long.parseLong(req.cookie("userId")));
                List<Cliente> clientes = UsuarioService.obtenerHogares();
                viewModel.put("cliente", clientes);
                viewModel.put("name", admin.getNombre());
                viewModel.put("id", admin.getId());
                return new ModelAndView(viewModel, "admin/hogares.hbs");
            }
            else
                return new ModelAndView(null, "statusCodePages/404.hbs");
        } catch (Exception e) {
            return new ModelAndView(null, "statusCodePages/404.hbs");
        }
    }

    public static ModelAndView obtenerDispositivos(Request req, Response res) {
        try {
            Usuario admin = UsuarioService.obtenerUsuarioPorId(Long.parseLong(req.cookie("userId")));
            if (Token.isAuth(req.cookie("token"),req.params("id")))
            {
                HashMap<String, Object> viewModel = new HashMap<>();
                List<DispositivoInteligente> dispositivosInteligentes = DispositivoService.obtenerTodosDispositivosInteligentes();
                List<DispositivoEstandar> dispositivosEstandars = DispositivoService.obtenerTodosDispositivosEstandars();
                viewModel.put("dispositivosInteligentes", dispositivosInteligentes);
                viewModel.put("dispositivosEstandars", dispositivosEstandars);
                viewModel.put("name", admin.getNombre());
                viewModel.put("id", admin.getId());
                return new ModelAndView(viewModel, "admin/dispositivos.hbs");
            }else
                return new ModelAndView(null, "statusCodePages/404.hbs");

        } catch (Exception e) {
            return new ModelAndView(null, "statusCodePages/404.hbs");
        }
    }

    public String crearDispositivoInteligente() {
        String nombre = request.queryParams("nombre");
        Double consumo = Double.parseDouble(request.queryParams("consumoMensual"));
        DispositivoInteligente dispositivo = new DispositivoInteligente();
        dispositivo.setNombre(nombre);
        dispositivo.setConsumoMensual(consumo);
        DispositivoService.persistir(dispositivo);
        response.status(200);
        response.redirect("/administrador/"+request.cookie("userId")+"/dispositivos");
        return null;
    }
    public String crearDispositivoEstandar() {
        String nombre = request.queryParams("nombre");
        int horasDeUsoDiarias = Integer.parseInt(request.queryParams("horasDeUsoDiarias"));
        DispositivoEstandar dispositivo = new DispositivoEstandar();
        dispositivo.setNombre(nombre);
        dispositivo.setHorasDeUsoDiarias(horasDeUsoDiarias);
        dispositivo.setBajoConsumo(false);
        String consumo = request.queryParams("bajoConsumo");
        if(consumo!=null)
        {
            dispositivo.setBajoConsumo(true);
        }
        DispositivoService.persistir(dispositivo);
        response.status(200);
        response.redirect("/administrador/"+request.cookie("userId")+"/dispositivos");
        return null;
    }

    public static ModelAndView generarReporteHogar(Request req, Response res) {
    	HashMap<String, Object> viewModel = new HashMap<>();
    	Usuario admin = UsuarioService.obtenerUsuarioPorId(Long.parseLong(req.cookie("userId")));
        List<Cliente> clientes = UsuarioService.obtenerHogares();
        try {
            LocalDate inicio = LocalDate.parse(req.queryParams("inicioPeriodo"));
            LocalDate fin = LocalDate.parse(req.queryParams("finPeriodo"));

            clientes.forEach(c ->{
               c.setConsumoTotal(GeneradorReportes.getReportePorHogar(c, inicio,fin ));
            });
            viewModel.put("cliente", clientes);
            viewModel.put("name", admin.getNombre());
            viewModel.put("id", admin.getId());
            return new ModelAndView(viewModel, "admin/hogares.hbs");
        } catch (NullPointerException e) {
        	viewModel.put("cliente", clientes);
            viewModel.put("name", admin.getNombre());
            viewModel.put("id", admin.getId());
            viewModel.put("consumo","No tiene consumo");
        	return new ModelAndView(viewModel, "admin/hogares.hbs");
        }
    }
    

}


