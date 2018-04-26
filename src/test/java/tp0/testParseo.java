package tp0;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import modelo.Cliente;
import modelo.Dispositivo;
import modelo.Parser;
import modelo.TipoIdentificacion;
import modelo.repositorios.RepositorioClientes;

public class testParseo {
	
	Parser parser2 = new Parser();
	Cliente clienteHarcodeado = new Cliente("Juan","Perez",TipoIdentificacion.DNI,123,48262937,"Medrano 951","JuanATR","qwerty");
	Dispositivo tele=new Dispositivo("tele",2);
	Dispositivo ipod=new Dispositivo("ipod",10);
	
	
	@Before
	public void init()
	{
		clienteHarcodeado.agregarDispositivo(tele);
		clienteHarcodeado.agregarDispositivo(ipod);
	}
	
	@Test
		public void parseoCorrecto() throws IOException
		{
			Cliente cliente2 = parser2.parsearCliente("src/main/resources/cliente.json");
			Assert.assertEquals(clienteHarcodeado.getNombre(),cliente2.getNombre());	
		
			Assert.assertEquals(clienteHarcodeado.getDispositivos().get(0).getNombre(),cliente2.getDispositivos().get(0).getNombre());	
		}
	@Test
	public void parseoCorrectoVariosClientes() throws IOException
	{
		List<Cliente> clientes = parser2.parsearClientes("src/main/resources/clientes.json");
		Assert.assertEquals(clienteHarcodeado.getNombre(),clientes.get(0).getNombre());	
	}
	
	
}
