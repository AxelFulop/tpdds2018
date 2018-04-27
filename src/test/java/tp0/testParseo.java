package tp0;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import modelo.Cliente;
import modelo.Dispositivo;
import modelo.Parser;
import modelo.TipoIdentificacion;

public class testParseo {
	
	Parser parser = new Parser();
	Cliente clienteHarcodeado = new Cliente("Juan","Perez",TipoIdentificacion.DNI,123,48262937,"Medrano 951","JuanATR","qwerty");
	Cliente mascheHijo = new Cliente("Antonio", "Mascherano", TipoIdentificacion.DNI, 40433999, 45673908, "calleFalsa 123", "hoyTeConvertisEnHeroe", "perro");
	Dispositivo tele=new Dispositivo("tele",2);
	Dispositivo ipod=new Dispositivo("ipod",10);
	
	@Test
	public void parseoCorrectoVariosClientes() throws IOException{
		List<Cliente> clientes = parser.parsearClientes("src/main/resources/clientes.json");
		Assert.assertEquals(clienteHarcodeado.getNombre(),clientes.get(0).getNombre());	
		Assert.assertEquals(mascheHijo.getNombre(),clientes.get(1).getNombre());	
	}	//HAY ERROR EN ESTE TEST
	
}
