package controllers;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import Servicios.DispositivoService;
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

            HashMap<String, Object> viewModel = new HashMap<>();
            Usuario admin = UsuarioService.obtenerUsuarioPorId(Long.parseLong(req.cookie("userId")));
            if (admin != null) {
                viewModel.put("name", admin.getNombre());
                viewModel.put("id", admin.getId());
            }
            return new ModelAndView(viewModel, "adminDash.hbs");
        } catch (Exception e) {
            return new ModelAndView(null, "statusCodePages/404.hbs");
        }
    }

    public static ModelAndView obtenerHogares(Request req, Response res) {
        try {
            HashMap<String, Object> viewModel = new HashMap<>();
            Usuario admin = UsuarioService.obtenerUsuarioPorId(Long.parseLong(req.cookie("userId")));
            List<Cliente> clientes = UsuarioService.obtenerHogares();
            viewModel.put("cliente", clientes);
            viewModel.put("name", admin.getNombre());
            viewModel.put("id", admin.getId());
            return new ModelAndView(viewModel, "admin/hogares.hbs");
        } catch (Exception e) {
            return new ModelAndView(null, "statusCodePages/404.hbs");
        }
    }

    public static ModelAndView obtenerDispositivos(Request req, Response res) {
        try {
            HashMap<String, Object> viewModel = new HashMap<>();
            Usuario admin = UsuarioService.obtenerUsuarioPorId(Long.parseLong(req.cookie("userId")));
            List<DispositivoInteligente> dispositivosInteligentes = DispositivoService.obtenerTodosDispositivosInteligentes();
            List<DispositivoEstandar> dispositivosEstandars = DispositivoService.obtenerTodosDispositivosEstandars();
            viewModel.put("dispositivosInteligentes", dispositivosInteligentes);
            viewModel.put("dispositivosEstandars", dispositivosEstandars);
            viewModel.put("name", admin.getNombre());
            viewModel.put("id", admin.getId());
            return new ModelAndView(viewModel, "admin/dispositivos.hbs");
        } catch (Exception e) {
            return new ModelAndView(null, "statusCodePages/404.hbs");
        }
    }

    public String crearDispositivoInteligente() {
        String nombre = request.queryParams("nombre");
        DispositivoInteligente dispositivo = new DispositivoInteligente();
        dispositivo.setNombre(nombre);
        DispositivoService.persistir(dispositivo);
        response.status(200);
        response.redirect("/dispositivos");
        return null;
    }
    public String crearDispositivoEstandar() {
        String nombre = request.queryParams("nombre");
        DispositivoEstandar dispositivo = new DispositivoEstandar();
        dispositivo.setNombre(nombre);
        DispositivoService.persistir(dispositivo);
        response.status(200);
        response.redirect("/dispositivos");
        return null;
    }

    public static ModelAndView generarReporteHogar(Request req, Response res) {
        try {
            String dias = req.queryParams("dias");
            Cliente cliente = UsuarioService.obtenerClientePorId(Long.parseLong(req.params("id")));
            HashMap<String, Object> viewModel = new HashMap<>();
            LocalDate fin = LocalDate.now();;
            LocalDate inicio = LocalDate.now().minusDays(Long.parseLong(dias));
            Double consumo = GeneradorReportes.getReportePorHogar(cliente, inicio,fin );
            viewModel.put("consumo",consumo);
            return new ModelAndView(viewModel, null);
        } catch (Exception e) {
            return new ModelAndView(null, "statusCodePages/404.hbs");
        }
    }
}


