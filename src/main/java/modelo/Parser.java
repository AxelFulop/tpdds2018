import java.io.File;

import java.io.FileReader;
import java.lang.reflect.Field;

import ejemplo.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeCreator;

public class Parser {

	public Cliente parserCliente() {
      
        
		JSONParser parser = new JSONParser();
		

		try {

			Object obj = parser
					.parse(new FileReader("src/ejemplo/cliente.json"));

			JSONObject unCliente = (JSONObject) obj;

			 String nombre = (String) unCliente.get("nombre");
			String apellido = (String) unCliente.get("apellido");
			TipoIdentificacion tipoId = (TipoIdentificacion) unCliente
					.get("tipoidentificacion");
			String user = (String) unCliente.get("userName");
			String password = (String) unCliente.get("password");

			Cliente cliente = new Cliente(nombre, apellido, tipoId, user,
					password);
			
			return cliente;

		} catch (Exception e) {
			e.printStackTrace();

		}
		
		

	}
	
}
