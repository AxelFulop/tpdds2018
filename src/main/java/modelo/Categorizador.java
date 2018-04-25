package modelo;

import java.util.LinkedHashMap;
import java.util.Map;

public class Categorizador {
	
	public Map<Categoria,TupleDouble> categorias = new LinkedHashMap<Categoria ,TupleDouble>();
	
	//Al declarlo de esta manera, cuando se isntancia el categorizador se asignan los valores
	public Categorizador()
	{
		this.categorias.put(Categoria.R1, new TupleDouble(0.0,150.0));
		this.categorias.put(Categoria.R2, new TupleDouble(150.0,325.0));
		this.categorias.put(Categoria.R3, new TupleDouble(325.0,400.0));
		this.categorias.put(Categoria.R4, new TupleDouble(400.0,450.0));
		this.categorias.put(Categoria.R5, new TupleDouble(450.0,500.0));
		this.categorias.put(Categoria.R6, new TupleDouble(500.0,600.0));
		this.categorias.put(Categoria.R7, new TupleDouble(600.0,700.0));
		this.categorias.put(Categoria.R8, new TupleDouble(700.0,1400.0));
		this.categorias.put(Categoria.R9, new TupleDouble(1400.0,Double.POSITIVE_INFINITY));
	}
	
	public void categorizar(Cliente cliente,int mes) {
		categorias.forEach((x,y)->{
			if (y.inBetween(cliente.getConsumoMensual(mes)))
			{
				cliente.setCategoria(x);
			}
			
			});
	}
	
}
