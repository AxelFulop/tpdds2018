package Servicios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import modelo.Cliente;
import modelo.Transformador;

public class Parser {
	
	public static List<Cliente> parsearClientes(String ruta) throws IOException{
		Gson gson = new Gson(); 

		try(Reader reader = new FileReader(ruta)) {
			return gson.fromJson(reader, new TypeToken<List<Cliente>>(){}.getType());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			return null; 
	}

	public static List<Transformador> parsearTransformadores(String ruta) throws IOException{
		Gson gson = new Gson();

		try(Reader reader = new FileReader(ruta)) {

			return gson.fromJson(reader, new TypeToken<List<Transformador>>(){}.getType());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
//TODO: HAcer adaoterTRansformador poara que segun el json nos devuelva un transformador de nuestro modelo
		return null;
	}
	
}
