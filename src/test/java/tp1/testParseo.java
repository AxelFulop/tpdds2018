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
		Assert.assertEquals(cliente1JSON.getNumId(),clientes.get(0).getNumId());	
		Assert.assertEquals(cliente2JSON.getNumId(),clientes.get(1).getNumId());
		//comparo Telefono
		Assert.assertEquals(cliente1JSON.getTelefono(),clientes.get(0).getTelefono());	
		Assert.assertEquals(cliente2JSON.getTelefono),clientes.get(1).getTelefono());
		//comparo Direccion
                Assert.assertEquals(cliente1JSON.getDireccion(),clientes.get(0).getDireccion());	
		Assert.assertEquals(cliente2JSON.getDireccion(),clientes.get(1).getDireccion());
		//comparo User
		 Assert.assertEquals(cliente1JSON.getUser(),clientes.get(0).getUser());	
		Assert.assertEquals(cliente2JSON.getUser(),clientes.get(1).getUser());
		//comparo Contrasenia
		 Assert.assertEquals(cliente1JSON.getContrasenia(),clientes.get(0).getContrasenia());	
		Assert.assertEquals(cliente2JSON.getContrasenia(),clientes.get(1).getContrasenia());
	}
}
