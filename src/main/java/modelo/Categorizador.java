package modelo;

import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Categorizador {
	
	public Map<Categoria,Tuple<Float,Float>> categorias = new LinkedHashMap<Categoria ,Tuple<Float,Float>>();
	
	public void Categorizador()
	{
		categorias.put(Categoria.R1, new Tuple(0,150));
		categorias.put(Categoria.R2, new Tuple(150,250));
	}
	
	public void categorizar(Cliente cliente) {
		

		
		
		
		categorias.forEach((k,v)->{
			if (v.inBetween(cliente.consumoDeLosEncendidos()))
			{
				cliente.setCategoria(k);;
			}
			
		});
		
		
	}
	
	public String obtenerCategoria(Float kwh)
	{
		
		
		return "A";
		
	}	
}
