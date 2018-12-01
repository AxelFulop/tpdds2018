package tp1;

import modelo.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import modelo.reglas.ReglaTemperaturaAlta;
import modelo.Actuadores.ActuadorEncenderAire;
import modelo.sensores.SensorTemperatura;
import java.util.ArrayList;
import java.util.List;

public class testRegla {

	Cliente cliente= new Cliente("Juan","Perez",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","juanATR","qwerty",0);
	DispositivoInteligente aire = new DispositivoInteligente ("aireAcondicionado",true,1d);
	SensorTemperatura sensorTemp = new SensorTemperatura();
	ActuadorEncenderAire actuadorPrenderAire;
	ReglaTemperaturaAlta reglaTemperaturaAlta;
	
	@Before
	public void init(){
		aire.apagar();

		List<DispositivoInteligente> dispositivos = new ArrayList<DispositivoInteligente>();
		dispositivos.add(aire);

		cliente.agregarDispositivoInteligente(aire);
		actuadorPrenderAire = new ActuadorEncenderAire(dispositivos);

		reglaTemperaturaAlta =  new ReglaTemperaturaAlta(actuadorPrenderAire,"unNombre");

		sensorTemp.addRegla(reglaTemperaturaAlta);
		
		aire.persistir();
		
	}
	
	
	@Test
	public void encendidoDeAireSiTemperaturaMayorA24 ()
	{	
		sensorTemp.setMedicion(30d);
		sensorTemp.tomarMedicion();
		Assert.assertTrue(aire.estaEncendido());
		aire.eliminar();
			
	}
	
}
