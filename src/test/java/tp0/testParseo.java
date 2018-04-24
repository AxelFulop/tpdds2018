package tp0;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Cliente;
import modelo.Parser;
import modelo.Parser2;
import modelo.TipoIdentificacion;

public class testParseo {
	
	
	Parser parser = new Parser();
	Parser2 parser2 = new Parser2();
	Cliente clienteHarcodeado = new Cliente("Juan","Perez",TipoIdentificacion.DNI,"JuanATR","qwerty");
	
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
			Assert.assertEquals(clienteHarcodeado.getNombre(),cliente2.getNombre());	
		}
	
	
}
