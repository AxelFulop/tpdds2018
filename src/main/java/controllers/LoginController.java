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
        if (!user.equals(null) && !name.equals("root") && !password.equals("root")) {
            request.session().attribute("username", name);
            request.session().attribute("password",password);
            response.status(200);
            response.redirect("/Clientes/"+user.getId());
        }
        else if(!user.equals(null) && name.equals("root") && password.equals( "root"))
        {
       	request.session().attribute("username", name);
        request.session().attribute("password",password);
        response.status(200);
       	response.redirect("/Administradores/"+ user.getId());
        }
        else
        {
        //aca habria que decirle que fallo el login
       	response.status(401);
        } 
       
        
        return null;
}
}


