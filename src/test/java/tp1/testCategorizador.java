package tp1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import modelo.Categorizador;
import modelo.Cliente;
import modelo.DispositivoEstandar;
import modelo.TipoIdentificacion;
import modelo.Inteligente;

public class testCategorizador {
	
	
	Cliente clienteHarcodeado = new Cliente("Juan","Perez",TipoIdentificacion.DNI,123,48262937,"Medrano 951","JuanATR","qwerty",0);
	DispositivoEstandar televisor = new DispositivoEstandar("tv", 1, new Inteligente());
	//Consumo = 1 kwh * 1 hsDeUsoPorDia * 30 dias = 30 (seria categoria 1 que va de 0 a 150)
	
		@Before
		public void init(){
			clienteHarcodeado.agregarDispositivo(televisor);
			clienteHarcodeado.setHorasDeUsoDelDia(televisor, 1);
		}	
	
		@Test
		public void categorizaCorrectamente(){
			Categorizador cat = new Categorizador();
			cat.recategorizar(clienteHarcodeado);
			Assert.assertEquals(clienteHarcodeado.getCategoria().getNombre(),"r1"); 
		} //HAY ERROR EN ESTE TEST, expected r1
		
}