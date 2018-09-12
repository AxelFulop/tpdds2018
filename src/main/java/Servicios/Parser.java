package Servicios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import modelo.Cliente;

public class Parser {
	
	public List<Cliente> parsearClientes(String ruta) throws IOException{
		Gson gson = new Gson(); 

		try(Reader reader = new FileReader(ruta)) {
	
			return gson.fromJson(reader, new TypeToken<List<Cliente>>(){}.getType());
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
			return null; 
	}
	
}
