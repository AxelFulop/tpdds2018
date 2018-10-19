import Servicios.Session;
import Servicios.UsuarioService;
import modelo.Administrador;
import modelo.Usuario;

import static spark.Spark.setIpAddress;
import static spark.Spark.setPort;
import static spark.Spark.staticFileLocation;

public class Global {
	private static final String IP_ADDRESS = System.getenv("OPENSHIFT_DIY_IP") != null ? System.getenv("OPENSHIFT_DIY_IP") : "localhost";
	private static final int PORT = System.getenv("OPENSHIFT_DIY_IP") != null ? Integer.parseInt(System.getenv("OPENSHIFT_DIY_IP")) : 9000;

	public static void main(String[] args) throws Exception {

		if(UsuarioService.obtenerUsuario("root","root")==null)
		{
			Usuario root = new Usuario();
			root.setContrasenia("root");
			root.setNombreUsuario("root");
			UsuarioService.persistir(root);
		}

		setIpAddress(IP_ADDRESS);
		setPort(PORT);
		staticFileLocation("/public");
		new Controller();
		//Aca le pego a las rutas que voy a usar y en las rutas le pego a los servicios para
		//interactuar con la bd..... Jamas accedo directamente a la bd
	}
}