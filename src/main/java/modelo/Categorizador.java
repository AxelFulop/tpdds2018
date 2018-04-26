package modelo;

import java.util.List;

public class Categorizador {
	
	public List<CategoriaResidencial> categorias;
	
	public Categorizador()
	{
		categorias.add(new CategoriaResidencial(0.0, 150.0, 18.76, 0.644) ); //R1
		categorias.add(new CategoriaResidencial(150.0, 325.0, 35.32, 0.644) ); //R2
		categorias.add(new CategoriaResidencial(325.0, 400.0, 60.71, 0.681) ); //R3
		categorias.add(new CategoriaResidencial(400.0, 450.0, 71.74, 0.738) ); //R4
		categorias.add(new CategoriaResidencial(450.0, 500.0, 110.38, 0.794) ); //R5
		categorias.add(new CategoriaResidencial(500.0, 600.0, 220.75, 0.832) ); //R6
		categorias.add(new CategoriaResidencial(600.0, 700.0, 443.59, 0.851) ); //R7
		categorias.add(new CategoriaResidencial(700.0, 1400.0, 545.96, 0.851) ); //R8
		categorias.add(new CategoriaResidencial(1400.0, Double.POSITIVE_INFINITY, 887.19, 0.851) ); //R9
	}
	
	public void reCategorizar(Cliente cliente) {
		this.categorias.forEach(c -> {
			if(c.pertenece(cliente)) {
				cliente.setCategoria(c);
			}
		} );
	}
	
}
