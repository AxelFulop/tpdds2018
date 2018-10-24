package server;



import modelo.Cliente;
import modelo.DispositivoEstandar;
import modelo.DispositivoInteligente;
import modelo.TipoIdentificacion;
import spark.Spark;
import spark.debug.DebugScreen;

	public class Server {
		
		public static void main(String[] args) {
			Bootstrap.main(null);
			Spark.port(8080);
			DebugScreen.enableDebugScreen();
			Router.configure(); 	
		}

	
}
