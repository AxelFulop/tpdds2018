package tp3;

import modelo.*;
import org.junit.Before;
import org.junit.Test;

import common.Coordenada;

public class testPersistenciaUsuarios {

	@Before
	public void init(){

	}

	@Test
	public void creoUsuarioYloPersistoYLoElimino() {
		int cantidadClientes = Cliente.obtenerTodos().size();
		Cliente cliente= new Cliente("Juan","Perez",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","JuanATR","qwerty",0);
		cliente.persistir();
		org.junit.Assert.assertEquals(cantidadClientes+1,Cliente.obtenerTodos().size());
		cliente.eliminar();
		org.junit.Assert.assertEquals(cantidadClientes,Cliente.obtenerTodos().size());
	}

	@Test
	public void modificoUsuarioYLoGuardo() {
		int cantidadClientes = Cliente.obtenerTodos().size();
		Cliente cliente= new Cliente("test","test",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","JuanATR","qwerty",0);
		Coordenada ubicacion = new Coordenada(1123D,1232D);
		cliente.setUbicacion(ubicacion);
		cliente.persistir();
		org.junit.Assert.assertEquals(Cliente.obtenerTodos().get(cantidadClientes).getUbicacion().getX(),ubicacion.getX());
		Coordenada nuevaUbicacion = new Coordenada(0D,0D);
		cliente.setUbicacion(nuevaUbicacion);
		cliente.actualizar();
		org.junit.Assert.assertEquals(Cliente.obtenerTodos().get(cantidadClientes).getUbicacion().getX(),nuevaUbicacion.getX());
		cliente.eliminar();
	}

}
