package controllers;

import Servicios.UsuarioService;
import modelo.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class LoginController {
	
	public static ModelAndView show(Request req, Response res){
		return new ModelAndView(null,"home/login.hbs");
	}
	
	public static ModelAndView login(Request request, Response response){
        String name = request.queryParams("nombreUsuario");
        String password = request.queryParams("contrasenia");
        Usuario user = UsuarioService.obtenerUsuario(name, password);
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
       response.status(401);
        }
       
        
        return null;
}
}


