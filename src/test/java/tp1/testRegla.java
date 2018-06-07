package tp1;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import modelo.Actuador;
import modelo.Cliente;
import modelo.DispositivoInteligente;
import modelo.Regla;
import modelo.Sensor;
import modelo.TipoIdentificacion;
import modelo.sensores.ActuadorEncenderAire;
import modelo.sensores.ReglaTemperaturaAlta;
import modelo.sensores.SensorTemperatura;

@SuppressWarnings("deprecation")
public class testRegla {

	Cliente cliente= new Cliente("Juan","Perez",TipoIdentificacion.DNI,123,48262937,"Medrano 951","juanATR","qwerty",0);
	DispositivoInteligente aire = new DispositivoInteligente ("aireAcondicionado");
	Sensor temp = new SensorTemperatura();
	Actuador prenderAire = new ActuadorEncenderAire();
	
	@Before
	public void init(){
		cliente.agregarDispositivoInteligente(aire);
		aire.apagar();
	}
	
	
	@Test
	public void encendidoDeAireSiTemperaturaMayorA24 ()
	{	
		Regla regla = new ReglaTemperaturaAlta(aire);
		regla.ejecutar();
		Assert.assertTrue(aire.estaEncendido());
		
		
	}
	
}
