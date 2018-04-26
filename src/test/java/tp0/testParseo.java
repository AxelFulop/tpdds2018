package tp0;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import modelo.Cliente;
import modelo.Parser;
import modelo.TipoIdentificacion;

public class testParseo {
	
	
	Parser parser2 = new Parser();
	Cliente clienteHarcodeado = new Cliente("Juan","Perez",TipoIdentificacion.DNI,123,48262937,"Medrano 951","JuanATR","qwerty");
	
	/*@Test
	public void parseoCorrecto()
	{
		Cliente cliente = parser.parsearCliente("src/main/resources/cliente.json");
		
		Assert.assertEquals(clienteHarcodeado,cliente);
		
		
		
	}*/
	@Test
		public void parseoCorrecto() throws IOException
		{
			Cliente cliente2 = parser2.parsearCliente("src/main/resources/cliente.json");
			//En este caso debieramos chequear que los objetos sean iguales
			Assert.assertEquals(clienteHarcodeado.getNombre(),cliente2.getNombre());	
		}
	
	
}
