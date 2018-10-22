package controllers;

import java.io.EOFException;

import Servicios.UsuarioService;
import modelo.Usuario;
import setup.ResponseError;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class LoginController {
	
	
	private static Request request;
    private static Response response;

   

    public LoginController(Request req, Response res) {
        request = req;
        response = res;
    }
	public static ModelAndView show(Request req, Response res){
		return new ModelAndView(null,"home/login.hbs");
	}
	
	public ModelAndView login() throws Exception{
		
        String username = request.queryParams("nombreUsuario");
        String password = request.queryParams("contrasenia");
        Usuario user = UsuarioService.obtenerUsuario(username, password);
        //login succes
        try{
       if (username.isEmpty() || password.isEmpty() || user == null) {
    	   response.redirect("/login");
			  
        }
       if(username.equals("root") && password.equals("root"))
        {
        response.status(200);
       	response.redirect("/administradores/"+ user.getId());
        }
       if(username.equals(user.getNombreUsuario()) && password.equals(user.getContrasenia()))
       {
       response.status(200);
       response.redirect("/clientes/"+ user.getId());
       }
        } 
        catch (Exception e) {
            response.status(500);
            response.body(e.toString());
        }
        return null;
}


	
	public static ModelAndView loginfailed(Request req, Response res){
		return new ModelAndView(null,"home/logginFailed.hbs");
	}

}