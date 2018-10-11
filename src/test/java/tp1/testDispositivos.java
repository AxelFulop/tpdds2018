package tp1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Cliente;
import modelo.DispositivoEstandar;
import modelo.DispositivoInteligente;
import modelo.Estado;
import modelo.TipoIdentificacion;

public class testDispositivos {
	Cliente cliente= new Cliente("Juan","Perez",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","JuanATR","qwerty",0);
	DispositivoEstandar tv = new DispositivoEstandar("tv", false,10d);
	DispositivoInteligente aire = new DispositivoInteligente("aire",true,1d); 
	DispositivoInteligente heladera = new DispositivoInteligente("heladera",true,1d); 
	
	@Before
	public void init(){
		cliente.agregarDispositivoEstandar(tv);
		cliente.agregarDispositivoInteligente(aire);	
		cliente.agregarDispositivoInteligente(heladera);
	}
	
	@Test
	 public void cantidadEnEstadoModoAhorro(){
		heladera.ponerseEnEstado(Estado.AHORROENERGIA);
		int cantidad = cliente.cantidadDeDispositivosEnAhorroDeEnergia();
		Assert.assertEquals(cantidad, 1);
	}
	
	@Test
	 public void cantidadDispositivosApagados(){
		aire.apagar();
		int cantidadApagados = cliente.cantidadDeDispositivosApagados();
		Assert.assertEquals(cantidadApagados, 1);
	}
	
	@Test
	 public void cantidadDispositivosEncendidos(){
		int cantidadP = cliente.cantidadDeDispositivosEncendidos();
		Assert.assertEquals(cantidadP, 2);
	}
	
	@Test
	public void cambioDeEstandarAInteligente(){
		Assert.assertSame(tv.getClass(), (new DispositivoEstandar("tv",false,1d)).getClass());
		Assert.assertEquals(cliente.getDispositivosInteligentes().size(), 2);
		cliente.ligarModuloAdaptador(tv);
		Assert.assertSame((new DispositivoInteligente("a",false,1d).getClass()),cliente.getDispositivosInteligentes().get(2).getClass());
	}
}
