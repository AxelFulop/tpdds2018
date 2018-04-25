package tp0;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Categoria;
import modelo.Categorizador;
import modelo.Cliente;
import modelo.Dispositivo;
import modelo.Parser;
import modelo.TipoIdentificacion;

public class testCategorizador {
	
	
	Cliente clienteHarcodeado = new Cliente("Juan","Perez",TipoIdentificacion.DNI,"JuanATR","qwerty");
	Dispositivo televevisor = new Dispositivo("tv", 10);
	Categorizador categorizador = new Categorizador();
	
	
		@Before
		public void init()
		{
			televevisor.setConsumoEnHorasAlMes(1, 155.0);	
			televevisor.setConsumoEnHorasAlMes(LocalDate.now().getMonthValue(), 456.45);
			clienteHarcodeado.setDispositivo(televevisor);
		}
	
	
		@Test
		public void categorizaCorrectamente() 
		{	
		//categorizador.categorizar(clienteHarcodeado,2);
			
		clienteHarcodeado.categorizarme();	
		Assert.assertEquals(Categoria.R5,clienteHarcodeado.getCategoria());
		clienteHarcodeado.getCategoria();
		}
	
	
}
