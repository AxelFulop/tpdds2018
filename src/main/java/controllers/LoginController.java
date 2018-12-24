package controllers;

import Servicios.SHA256Builder;
import Servicios.UsuarioService;
import modelo.Usuario;
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
		return new ModelAndView(null,"home/homeLogin.hbs");
	}
	
	public String login() throws Exception{
		
        String username = request.queryParams("nombreUsuario");
        String pass = request.queryParams("contrasenia");
        String password = SHA256Builder.generarHash256(pass);
        String passRoot = SHA256Builder.generarHash256("root");
        Usuario user = UsuarioService.obtenerUsuario(username, pass);
        //login succes
        try{
       if (username.isEmpty() || pass.isEmpty() || user == null) {
    	   response.redirect("/loginFailed");
			  
        }
       if(username.equals("root") && password.equals(passRoot))
        {
        response.status(200);
        response.cookie("userId",user.getId().toString());
       	response.redirect("/administrador/"+ user.getId());

        }
       if(username.equals(user.getNombreUsuario()) && password.equals(user.getContrasenia()))
       {
       response.status(200);
       response.cookie("userId",user.getId().toString());
       response.redirect("/clientes/"+ user.getId() + "/hogar");
       }
        } 
        catch (Exception e) {
            response.status(500);
            response.body(e.toString());
        }
       return null;
}

    public String logout() throws Exception{
                response.status(200);
                response.removeCookie("userId");
                response.redirect("/");
                return null;
    }


	public static ModelAndView loginfailed(Request req, Response res){
		return new ModelAndView(null,"statusCodePages/loginFailed.hbs");
	}

}