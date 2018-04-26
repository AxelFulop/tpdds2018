package modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import modelo.repositorios.RepositorioClientes;


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
	
	public List<Cliente> parsearClientes(String ruta) throws IOException
	{
	Gson gson = new Gson(); 

	try(Reader reader = new FileReader(ruta)) {
	
		return gson.fromJson(reader, new TypeToken<List<Cliente>>(){}.getType());
	
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	return null; 
	
	}
}
