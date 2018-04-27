package tp0;

import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import modelo.Categorizador;
import modelo.Cliente;
import modelo.Dispositivo;
import modelo.TipoIdentificacion;

public class testCategorizador {
	
	
	Cliente clienteHarcodeado = new Cliente("Juan","Perez",TipoIdentificacion.DNI,123,48262937,"Medrano 951","JuanATR","qwerty");
	Dispositivo televevisor = new Dispositivo("tv", 10);
	
		@Before
		public void init(){
			televevisor.setConsumoEnHorasAlMes(LocalDate.now().getMonthValue(), 456.45);
			clienteHarcodeado.agregarDispositivo(televevisor);
		}	
	
		@Test
		public void categorizaCorrectamente(){
			Categorizador cat = new Categorizador();
			cat.recategorizar(clienteHarcodeado);
			Assert.assertEquals(clienteHarcodeado.getCategoria().getNombre(),"r5");
		} //HAY ERROR EN ESTE TEST
		
}
