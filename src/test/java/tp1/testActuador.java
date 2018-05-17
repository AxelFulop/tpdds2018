package tp1;

import org.junit.Before;
import org.junit.Test;

import modelo.Actuador;
import modelo.Cliente;
import modelo.Dispositivo;
import modelo.Sensor;
import modelo.TipoIdentificacion;
import modelo.sensores.Temperatura;

public class testActuador {

	Cliente cliente= new Cliente("Juan","Perez",TipoIdentificacion.DNI,123,48262937,"Medrano 951","JuanATR","qwerty");
	Dispositivo televisor = new Dispositivo("tv", 10);
	Dispositivo computadora = new Dispositivo("compu", 15);
	Dispositivo aire = new Dispositivo("Aire", 20);
	Sensor temp = new Temperatura();
	Actuador prenderAire = new Actuador(temp, aire);
	@Before
	public void init(){
		televisor.convertirAInteligente();
		computadora.convertirAInteligente();
		aire.convertirAInteligente();
		cliente.agregarDispositivo(televisor);
		cliente.agregarDispositivo(computadora);	
		cliente.agregarDispositivo(aire);
		
		prenderAire.setP1(s->s.tomarMedicion()>22);
		prenderAire.setP2(d -> d.setNombre("Pepe"));

	}
	@Test
	public void definirActuadorYCorroborarAccionRealizada()
	{
		
	}
	
}
