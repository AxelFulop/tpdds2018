package modelo;

import java.io.FileReader;



import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import modelo.repositorios.RepositorioClientes;


public class Parser {
	
	Cliente cliente;
	
	public Cliente parsearCliente(String ruta)//
	{
		JSONParser parser = new JSONParser();
			try {
			Object obj = parser.parse(new FileReader(ruta));
			JSONObject unCliente = (JSONObject) obj;

			String nombre = (String) unCliente.get("nombre");
			String apellido = (String) unCliente.get("apellido");
			TipoIdentificacion tipoId = TipoIdentificacion.DNI;
			String user = (String) unCliente.get("userName");
			String password = (String) unCliente.get("password");

			cliente = new Cliente(nombre, apellido, tipoId, user,password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		RepositorioClientes.getInstance();
		RepositorioClientes.addCliente(cliente);
		
		return cliente;

	}
	
}
