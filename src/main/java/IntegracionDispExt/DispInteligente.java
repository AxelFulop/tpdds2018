/*package IntegracionDispExt;

import Servicios.JsonTransformer;
import spark.Spark;
import spark.debug.DebugScreen;


public class DispInteligente {
	private static Long idCliente = 1l;
	private static Long idDispositivo = 6l;
	private static String estado = "encendido"; //encendido ó apagado

	public static void main(String[] args) {

		System.out.println("== START DISPOSITIVO ==");
		Spark.port(8081);
		DebugScreen.enableDebugScreen();
		
		Spark.post("/cliente/dispositivo", (req, res) -> {
            String idClient = req.queryParams("idCliente");
            String idDisp = req.queryParams("idDispositivo");
            if(idClient.equals(idCliente.toString()) && idDisp.equals(idDispositivo.toString()) ) {
            	String action = req.queryParams("accion");
            	if(action.equals("encender")) {
            		estado = "encendido";
            		res.status(200);
            	}
            	else if(action.equals("apagar")) {
            		estado = "apagado";
            		res.status(200);
            	}
            	else {
            		res.status(404);
            		System.out.println("Accion no reconocida");
            	}
            	System.out.println("Dispositivo en estado " + estado);
            }
            else {
            	res.status(404);
            	System.out.println("Acceso denegado");
            }
           	return "";

        }, new JsonTransformer());
			
			
	}

}*/
