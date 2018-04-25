package tp0;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Cliente;
import modelo.Dispositivo;
import modelo.TipoIdentificacion;
public class testCliente {
	Cliente cliente= new Cliente("Juan","Perez",TipoIdentificacion.DNI,"JuanATR","qwerty");
	Dispositivo televisor = new Dispositivo("tv", 10);
	Dispositivo computadora = new Dispositivo("compu", 15);
	Dispositivo heladera = new Dispositivo("heladera", 20);
	
	@Before
	public void init(){
		
		cliente.setDispositivo(televisor);
		cliente.setDispositivo(computadora);	
		cliente.setDispositivo(heladera);

	}
	
	@Test
	 public void cantidadDeDispositivos(){
		int cantidad;
		cantidad = cliente.cantidadDeDispositivos();
		Assert.assertEquals(cantidad, 3);
	};
	@Test
	 public void cantidadDispositivosApagados(){
		int cantidadApagados;
		cantidadApagados = cliente.cantidadDeDispositivosEnEstado(false);
		Assert.assertEquals(cantidadApagados, 3);
	};
	@Test
	 public void cantidadDispositivosEncendidos(){
		heladera.setEstado(true);
		int cantidadP;
		cantidadP = cliente.cantidadDeDispositivosEnEstado(true);
		Assert.assertEquals(cantidadP, 1);
	};
	@Test
	 public void algunDispEncendido(){
		heladera.setEstado(true);
		boolean estado;
		estado = cliente.algunDispostivoEncendido();
		Assert.assertTrue(estado);
	};
	@Test
	 public void ningunDispEncendido(){
		boolean estado;
		estado = cliente.algunDispostivoEncendido();
		Assert.assertFalse(estado);
	};
}
