package controllers;

import java.io.EOFException;

import Servicios.UsuarioService;
import modelo.Usuario;
import setup.ResponseError;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class LoginController {
	
	public static ModelAndView show(Request req, Response res){
		return new ModelAndView(null,"home/login.hbs");
	}
	
	public static ModelAndView login(Request request, Response response) throws Exception{
		
        String name = request.queryParams("nombreUsuario");
        String password = request.queryParams("contrasenia");
        Usuario user = UsuarioService.obtenerUsuario(name, password);
        //login succes
        try{
        if (!user.equals(null) && !name.equals("root") && !password.equals("root")) {
            request.session().attribute("username", name);
            request.session().attribute("password",password);
            response.status(200);
            response.redirect("/clientes/"+user.getId());
        }
       if(!user.equals(null) && name.equals("root") && password.equals( "root"))
        {
       	request.session().attribute("username", name);
        request.session().attribute("password",password);
        response.status(200);
       	response.redirect("/administradores/"+ user.getId());
        }
        } 
        catch (Exception e) {
            response.status(500);
            response.body(e.toString());
        }
      
 
        
        return null;
}
}


