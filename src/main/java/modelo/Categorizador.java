package modelo;

import java.util.ArrayList;
import java.util.List;

public class Categorizador {
	
	public List<CategoriaResidencial> categorias = new ArrayList<CategoriaResidencial>();
	
	public  Categorizador()
	{
		CategoriaResidencial r1 = new CategoriaResidencial("r1",0.0, 150.0, 18.76, 0.644);
		categorias.add(r1);
		CategoriaResidencial r2 = new CategoriaResidencial("r2",150.0, 325.0, 35.32, 0.644);
		categorias.add(r2);
		CategoriaResidencial r3 = new CategoriaResidencial("r3",325.0, 400.0, 60.71, 0.681);
		categorias.add(r3);
		CategoriaResidencial r4 = new CategoriaResidencial("r4",400.0, 450.0, 71.74, 0.738);
		categorias.add(r4);
		CategoriaResidencial r5 = new CategoriaResidencial("r5",450.0, 500.0, 110.38, 0.794);
		categorias.add(r5);
		CategoriaResidencial r6 = new CategoriaResidencial("r6",500.0, 600.0, 220.75, 0.832);
		categorias.add(r6);
		CategoriaResidencial r7 = new CategoriaResidencial("r7",600.0, 700.0, 443.59, 0.851);
		categorias.add(r7);
		CategoriaResidencial r8 = new CategoriaResidencial("r8",700.0, 1400.0, 545.96, 0.851);
		categorias.add(r8);
		CategoriaResidencial r9 = new CategoriaResidencial("r9",1400.0, Double.POSITIVE_INFINITY, 887.19, 0.851);
		categorias.add(r9);
	}
	
	public void recategorizar(Cliente cliente) {
		this.categorias.forEach(c -> {
			if(c.pertenece(cliente)) {
				cliente.setCategoria(c);
			}
		} );
	}
	
}
