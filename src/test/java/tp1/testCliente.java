package tp1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import modelo.Cliente;
import modelo.DispositivoEstandar;
import modelo.DispositivoInteligente;
import modelo.TipoIdentificacion;

public class testCliente {
	Cliente cliente= new Cliente("Juan","Perez",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","JuanATR","qwerty",0);
	DispositivoEstandar televisor = new DispositivoEstandar("tv", false,10d);
	DispositivoInteligente computadora = new DispositivoInteligente("computadora",true,1d);
	DispositivoInteligente heladera = new DispositivoInteligente("heladera",true,1d);
	
	@Before
	public void init(){
		cliente.agregarDispositivoEstandar(televisor);
		cliente.agregarDispositivoInteligente(computadora);	
		cliente.agregarDispositivoInteligente(heladera);
	}
	
	@Test
	 public void cantidadDeDispositivos(){
		int cantidad = cliente.cantidadDeDispositivos();
		Assert.assertEquals(cantidad, 3);
	}
	@Test
	 public void cantidadDispositivosApagados(){
		heladera.apagar();
		int cantidadApagados = cliente.cantidadDeDispositivosApagados();
		Assert.assertEquals(cantidadApagados, 1);
	}
	@Test
	 public void cantidadDispositivosEncendidos(){
		int cantidadP = cliente.cantidadDeDispositivosEncendidos();
		Assert.assertEquals(cantidadP, 2);
	}
	
	@Test
	public void puntajeCliente(){
		cliente.ligarModuloAdaptador(televisor); // 10 puntos
		//Tiene 30 puntos por agregar 2 dispositivos en el Before
		Assert.assertEquals(cliente.getPuntos(), 40);
	}
}