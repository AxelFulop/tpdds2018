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
import modelo.reglas.ReglaTemperaturaAlta;
import modelo.sensores.ActuadorEncenderAire;
import modelo.sensores.SensorTemperatura;

@SuppressWarnings("deprecation")
public class testRegla {

	Cliente cliente= new Cliente("Juan","Perez",TipoIdentificacion.DNI,123,48262937,"Medrano 951","juanATR","qwerty",0);
	DispositivoInteligente aire = new DispositivoInteligente ("aireAcondicionado",true,1);
	Sensor sensorTemp = new SensorTemperatura();
	Actuador prenderAire = new ActuadorEncenderAire();
	Regla reglaTemperaturaAlta = new ReglaTemperaturaAlta(aire,cliente);
	
	@Before
	public void init(){
		cliente.agregarDispositivoInteligente(aire);
		aire.apagar();
		sensorTemp.addRegla(reglaTemperaturaAlta);
	}
	
	
	@Test
	public void encendidoDeAireSiTemperaturaMayorA24 ()
	{	
		sensorTemp.tomarMedicion();
		Assert.assertTrue(aire.estaEncendido());
		
		
	}
	
}
