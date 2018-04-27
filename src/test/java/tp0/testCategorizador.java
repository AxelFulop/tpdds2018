package tp0;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import modelo.Categorizador;
import modelo.Cliente;
import modelo.Dispositivo;
import modelo.TipoIdentificacion;

public class testCategorizador {
	
	
	Cliente clienteHarcodeado = new Cliente("Juan","Perez",TipoIdentificacion.DNI,123,48262937,"Medrano 951","JuanATR","qwerty");
	Dispositivo televevisor = new Dispositivo("tv", 1);
	//Consumo = 1 kwh * 24 hs * 30 dias = 720 (seria categoria 8 que va de 700 a 1400)
	
		@Before
		public void init(){
			clienteHarcodeado.agregarDispositivo(televevisor);
		}	
	
		@Test
		public void categorizaCorrectamente(){
			Categorizador cat = new Categorizador();
			cat.recategorizar(clienteHarcodeado);
			Assert.assertEquals(clienteHarcodeado.getCategoria().getNombre(),"r8");
		} //HAY ERROR EN ESTE TEST
		
}
