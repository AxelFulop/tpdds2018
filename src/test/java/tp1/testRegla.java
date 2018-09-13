package tp1;

import modelo.*;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import modelo.reglas.ReglaTemperaturaAlta;
import modelo.Actuadores.ActuadorEncenderAire;
import modelo.sensores.SensorTemperatura;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class testRegla {

	Cliente cliente= new Cliente("Juan","Perez",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","juanATR","qwerty",0);
	DispositivoInteligente aire = new DispositivoInteligente ("aireAcondicionado",true,1d);
	Sensor sensorTemp = new SensorTemperatura();
	Actuador actuadorPrenderAire;
	Regla reglaTemperaturaAlta;
	
	@Before
	public void init(){
		aire.apagar();

		List<DispositivoInteligente> dispositivos = new ArrayList<DispositivoInteligente>();
		dispositivos.add(aire);

		cliente.agregarDispositivoInteligente(aire);
		actuadorPrenderAire = new ActuadorEncenderAire(dispositivos);

		reglaTemperaturaAlta =  new ReglaTemperaturaAlta(actuadorPrenderAire);

		sensorTemp.addRegla(reglaTemperaturaAlta);
	}
	
	
	@Test
	public void encendidoDeAireSiTemperaturaMayorA24 ()
	{	
		sensorTemp.tomarMedicion();
		Assert.assertTrue(aire.estaEncendido());
		
		
	}
	
}
