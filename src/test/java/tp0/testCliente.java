package tp0;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Cliente;
import modelo.Dispositivo;
import modelo.TipoIdentificacion;
public class testCliente {
	Cliente cliente= new Cliente("Juan","Perez",TipoIdentificacion.DNI,123,48262937,"Medrano 951","JuanATR","qwerty");
	Dispositivo televisor = new Dispositivo("tv", 10);
	Dispositivo computadora = new Dispositivo("compu", 15);
	Dispositivo heladera = new Dispositivo("heladera", 20);
	
	@Before
	public void init(){
		televisor.convertirAInteligente();
		computadora.convertirAInteligente();
		heladera.convertirAInteligente();
		cliente.agregarDispositivo(televisor);
		cliente.agregarDispositivo(computadora);	
		cliente.agregarDispositivo(heladera);

	}
	
	@Test
	 public void cantidadDeDispositivos(){
		int cantidad = cliente.cantidadDeDispositivos();
		Assert.assertEquals(cantidad, 3);
	}
	@Test
	 public void cantidadDispositivosApagados(){
		int cantidadApagados = cliente.cantidadDeDispositivosApagados();
		Assert.assertEquals(cantidadApagados, 3);
	}
	@Test
	 public void cantidadDispositivosEncendidos(){
		heladera.getAdaptadorInteligente().encender();
		int cantidadP = cliente.cantidadDeDispositivosEncendidos();
		Assert.assertEquals(cantidadP, 1);
	}
	@Test
	 public void algunDispositivoEncendido(){
		heladera.getAdaptadorInteligente().encender();
		boolean estado = cliente.algunDispostivoEncendido();
		Assert.assertTrue(estado);
	}
	@Test
	 public void ningunDispositivoEncendido(){
		boolean estado = cliente.algunDispostivoEncendido();
		Assert.assertFalse(estado);
	}
	
}
