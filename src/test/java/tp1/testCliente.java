package tp1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Cliente;
import modelo.Dispositivo;
import modelo.Inteligente;
import modelo.TipoIdentificacion;

public class testCliente {
	Cliente cliente= new Cliente("Juan","Perez",TipoIdentificacion.DNI,123,48262937,"Medrano 951","JuanATR","qwerty",0);
	Dispositivo televisor = new Dispositivo("tv", 10, null); //dispositivo estandar
	Dispositivo computadora = new Dispositivo("compu", 15, new Inteligente()); //dispositivo inteligente
	Dispositivo heladera = new Dispositivo("heladera", 20, new Inteligente()); //dispositivo inteligente
	
	@Before
	public void init(){
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
		heladera.getAdaptadorInteligente().encender();
		int cantidadApagados = cliente.cantidadDeDispositivosApagados();
		Assert.assertEquals(cantidadApagados, 1);
	}
	@Test
	 public void cantidadDispositivosEncendidos(){
		heladera.getAdaptadorInteligente().encender();
		computadora.getAdaptadorInteligente().encender();
		int cantidadP = cliente.cantidadDeDispositivosEncendidos();
		Assert.assertEquals(cantidadP, 2);
	}
	public void puntajeCliente(){
		cliente.adaptarDispositivoEstandar(televisor);
		int puntaje = cliente.puntaje();
		Assert.assertEquals(puntaje, 40);
	}
}