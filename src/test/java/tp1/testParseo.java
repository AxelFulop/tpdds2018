package tp1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import modelo.Cliente;
import modelo.Dispositivo;
import modelo.Parser;
import modelo.TipoIdentificacion;
import modelo.Inteligente;

public class testParseo {
	
	
	Parser parser = new Parser();
	List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
	Cliente cliente1JSON = new Cliente("Juan","Perez",TipoIdentificacion.DNI,123,48262937,"Medrano 951","JuanATR","qwerty",0);
	Cliente cliente2JSON = new Cliente("Antonio", "Mascherano", TipoIdentificacion.DNI, 40433999, 45673908, "calleFalsa 123", "hoyTeConvertisEnHeroe", "perro",0);
	Dispositivo tele = new Dispositivo("tele",2,new Inteligente());
 	Dispositivo ipod = new Dispositivo("ipod",10,new Inteligente());
 	
	@Before
	public void init(){
		
		cliente1JSON.agregarDispositivo(tele);
		cliente1JSON.agregarDispositivo(ipod);	
		cliente2JSON.agregarDispositivo(tele);
		cliente2JSON.agregarDispositivo(ipod);	

	}
 	

	@Test
	public void parseoCorrectoVariosClientes() throws IOException{
		List<Cliente> clientes = parser.parsearClientes("src/main/resources/clientes.json");
		Assert.assertEquals(cliente1JSON.getNombre(),clientes.get(0).getNombre());	
		Assert.assertEquals(cliente2JSON.getNombre(),clientes.get(1).getNombre());

	}	
}