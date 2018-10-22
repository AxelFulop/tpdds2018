package server;


import Servicios.UsuarioService;
import modelo.Usuario;
import spark.Spark;
import spark.debug.DebugScreen;

	public class Server {
		
		public static void main(String[] args) {
			if(UsuarioService.obtenerUsuario("root","root")==null)
			{
				Usuario root = new Usuario();
				root.setContrasenia("root");
				root.setNombreUsuario("root");
				UsuarioService.persistir(root);
			}

			Spark.port(8080);
			DebugScreen.enableDebugScreen();
			Router.configure();
		}

	
}
