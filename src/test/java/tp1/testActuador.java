package tp1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Assert;

import modelo.Actuador;
import modelo.Cliente;
import modelo.Dispositivo;
import modelo.Sensor;
import modelo.TipoIdentificacion;
import modelo.sensores.Temperatura;
import modelo.Inteligente;

public class testActuador {

	Cliente cliente= new Cliente("Juan","Perez",TipoIdentificacion.DNI,123,48262937,"Medrano 951","juanATR","qwerty",0);
	Dispositivo aire = new Dispositivo("aireAcondicionado", 20,new Inteligente());
	Sensor temp = new Temperatura();
	Actuador prenderAire = new Actuador(cliente,temp );
	@Before
	public void init(){

		cliente.agregarDispositivo(aire);
		

	}
	
	@Test
	public void estadoActualDelAireAcondicionado()
	{	

		Assert.assertTrue(aire.getAdaptadorInteligente().estaApagado());
				
		
	}
	@Test
	public void encendidoDeAireAcondicionadoSiLaTemperaturaNoEsLaDeseada()
	{	
		prenderAire.encenderAireSiTemperaturaMayorA((float)24);
		Assert.assertTrue(aire.getAdaptadorInteligente().estaEncendido());
		
		
	}
	
}
