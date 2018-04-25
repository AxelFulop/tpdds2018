package modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.google.gson.Gson;


public class Parser {
	
	public Cliente parsearCliente(String ruta) throws IOException
	{
	Gson gson = new Gson(); 
	
	try(Reader reader = new FileReader(ruta)) {
		
		return gson.fromJson(reader, Cliente.class);
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	return null; 
	
	}
}
