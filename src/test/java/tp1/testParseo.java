package tp1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import modelo.Cliente;
import modelo.DispositivoEstandar;
import modelo.Parser;
import modelo.TipoIdentificacion;
import modelo.Inteligente;

public class testParseo {
	
	
	Parser parser = new Parser();
	List<DispositivoEstandar> dispositivos = new ArrayList<DispositivoEstandar>();
	Cliente cliente1JSON = new Cliente("Juan","Perez",TipoIdentificacion.DNI,123,48262937,"Medrano 951","juanATR","qwerty",0);
	Cliente cliente2JSON = new Cliente("Antonio", "Mascherano", TipoIdentificacion.DNI, 40433999, 45673908, "calleFalsa 123", "hoyTeConvertisEnHeroe", "perro",0);
	DispositivoEstandar tele = new DispositivoEstandar("tele",2,new Inteligente());
 	DispositivoEstandar ipod = new DispositivoEstandar("ipod",10,new Inteligente());
 	
	@Before
	public void init(){
		
		cliente1JSON.agregarDispositivo(tele);
		cliente1JSON.agregarDispositivo(ipod);	
		cliente2JSON.agregarDispositivo(tele);
		cliente2JSON.agregarDispositivo(ipod);	

	}
 	

	/*
	@Test
	public void parseoCorrectoVariosClientes() throws IOException{
		List<Cliente> clientes = parser.parsearClientes("src/main/resources/clientes.json");
		// comparo nombres
		Assert.assertEquals(cliente1JSON.getNombre(),clientes.get(0).getNombre());	
		Assert.assertEquals(cliente2JSON.getNombre(),clientes.get(1).getNombre());
		//comparo apellidos
		Assert.assertEquals(cliente1JSON.getApellido(),clientes.get(0).getApellido());	
		Assert.assertEquals(cliente2JSON.getApellido(),clientes.get(1).getApellido());
		//comparo tipo identificacion
		Assert.assertEquals(cliente1JSON.getTipoIdentificacion(),clientes.get(0).getTipoIdentificacion());	
		Assert.assertEquals(cliente2JSON.getTipoIdentificacion(),clientes.get(1).getTipoIdentificacion());
		//comparo numero identificacion 
		Assert.assertEquals(cliente1JSON.getNumeroIdentificacion(),clientes.get(0).getNumeroIdentificacion());	
		Assert.assertEquals(cliente2JSON.getNumeroIdentificacion(),clientes.get(1).getNumeroIdentificacion());
		//comparo Telefono
		Assert.assertEquals(cliente1JSON.getTelefono(),clientes.get(0).getTelefono());	
		Assert.assertEquals(cliente2JSON.getTelefono(),clientes.get(1).getTelefono());
		//comparo Direccion
                Assert.assertEquals(cliente1JSON.getDomicilio(),clientes.get(0).getDomicilio());	
		Assert.assertEquals(cliente2JSON.getDomicilio(),clientes.get(1).getDomicilio());
		//comparo User
		 Assert.assertEquals(cliente1JSON.getNombreUsuario(),clientes.get(0).getNombreUsuario());	
		Assert.assertEquals(cliente2JSON.getNombreUsuario(),clientes.get(1).getNombreUsuario());
		//comparo Contrasenia
		 Assert.assertEquals(cliente1JSON.getContrasena(),clientes.get(0).getContrasena());	
		Assert.assertEquals(cliente2JSON.getContrasena(),clientes.get(1).getContrasena());
	}
	*/
}
