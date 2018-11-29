package tp3;


import Servicios.Parser;
import common.Coordenada;
import modelo.Cliente;
import modelo.TipoIdentificacion;
import modelo.Transformador;
import modelo.ZonaGeografica;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class testPersistenciaTransformadores {

	Transformador transformadorAlmagro = new Transformador();
	Transformador transformadorCaballito = new Transformador();
	Transformador transformadorColegiales = new Transformador();

	List<Transformador> listaTransformadores1 = new ArrayList<Transformador>();
	List<Transformador> listaTransformadores2 = new ArrayList<Transformador>();

	ZonaGeografica zona1 = new ZonaGeografica();
	ZonaGeografica zona2 = new ZonaGeografica();

	@Before
	public void init() {

		transformadorAlmagro.setUbicacion(new Coordenada(0D, 0D));

		transformadorCaballito.setUbicacion(new Coordenada(5D, 5D));

		transformadorColegiales.setUbicacion(new Coordenada(15D, 15D));
		
		zona1.addTransformador(transformadorAlmagro);
		zona1.addTransformador(transformadorCaballito);
		zona2.addTransformador(transformadorColegiales);

	}


	@Test
	public void peristoTransformadoresYLosObtengo(){
		int cantidadTransformadores = Transformador.obtenerTodos().size();

		transformadorAlmagro.persistir();
		transformadorCaballito.persistir();
		transformadorColegiales.persistir();

		Assert.assertEquals(cantidadTransformadores+3,Transformador.obtenerTodos().size());

		transformadorColegiales.eliminar();
		transformadorCaballito.eliminar();
		transformadorAlmagro.eliminar();
	}

	@Test
	public void parseoTransformadorYpersisto()throws IOException {
		int cantidadTransformadores = Transformador.obtenerTodos().size();
		List<Transformador> transformadores= Parser.parsearTransformadores("src/main/resources/transformadores.json");
		transformadores.forEach(transformador -> {
			transformador.persistir();
		});
		Assert.assertEquals(cantidadTransformadores+1,Transformador.obtenerTodos().size());
		transformadores.forEach(transformador -> {
			transformador.eliminar();
		});
	}

}
