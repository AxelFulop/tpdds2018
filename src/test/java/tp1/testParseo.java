package tp1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import modelo.Cliente;
import modelo.DispositivoEstandar;
import modelo.DispositivoInteligente;
import modelo.Servicios.Parser;
import modelo.TipoIdentificacion;


public class testParseo {
	
	
	Parser parser = new Parser();
	List<DispositivoEstandar> dispositivos = new ArrayList<DispositivoEstandar>();
	Cliente cliente1JSON = new Cliente("Juan","Perez",TipoIdentificacion.DNI,123,48262937,"Medrano 951","juanATR","qwerty",0);
	Cliente cliente2JSON = new Cliente("Antonio", "Mascherano", TipoIdentificacion.DNI, 40433999, 45673908, "calleFalsa 123", "hoyTeConvertisEnHeroe", "perro",0);
	DispositivoEstandar tele = new DispositivoEstandar("tele",false,2);
 	DispositivoEstandar ipod = new DispositivoEstandar("ipod",false,10);
 	DispositivoInteligente aire = new DispositivoInteligente("aire",true,5);
 	DispositivoInteligente heladera = new DispositivoInteligente("heladera",true,5);
 	
	@Before
	public void init(){
		
		cliente1JSON.agregarDispositivoEstandar(tele);
		cliente1JSON.agregarDispositivoEstandar(ipod);	
		cliente2JSON.agregarDispositivoEstandar(tele);
		cliente2JSON.agregarDispositivoEstandar(ipod);
		cliente1JSON.agregarDispositivoInteligente(aire);
		cliente1JSON.agregarDispositivoInteligente(heladera);
		cliente2JSON.agregarDispositivoInteligente(aire);
		cliente2JSON.agregarDispositivoInteligente(heladera);
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
	
	@Test
	public void parseoCorrectoDeDispositivo() throws IOException {
		List<Cliente> clientes = parser.parsearClientes("src/main/resources/clientes.json");
		Assert.assertEquals(cliente1JSON.getDispositivosEstandares().get(0).getNombre(), clientes.get(0).getDispositivosEstandares().get(0).getNombre());
	}
	
	
	@Test
	public void parseoCorrectoConDispositivosInteligentes() throws IOException {
		List<Cliente> clientes = parser.parsearClientes("src/main/resources/clienteConDispInteligentes.json");
		Assert.assertEquals(cliente1JSON.getDispositivosInteligentes().get(0).getNombre(), clientes.get(0).getDispositivosInteligentes().get(0).getNombre());
	}
}
