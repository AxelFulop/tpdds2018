package tp4;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import Servicios.Session;
import Servicios.UsuarioService;
import modelo.Cliente;
import modelo.DispositivoEstandar;
import modelo.DispositivoInteligente;
import modelo.TipoIdentificacion;
import modelo.Usuario;

public class testUsuarioService {
	
	@Test
	public void persistoUsuarioYLoObtengo(){
	Cliente cliente3= new Cliente("lucas","rosol",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","luqui","asd",0);
    cliente3.persistir();
    Usuario user = UsuarioService.obtenerUsuario("luqui","asd");
    org.junit.Assert.assertEquals(user.getNombreUsuario(),"luqui");
    org.junit.Assert.assertEquals(user.getContrasenia(),"asd");
}
	
	@Test
	public void testObtenerDispositivosEstandar()
	{
		DispositivoEstandar tv = new DispositivoEstandar("tv", false,10d);
		tv.persistir();
		DispositivoEstandar aire = new DispositivoEstandar("aire",true,1d);
		aire.persistir();
		Cliente cliente= new Cliente("test","test",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","JuanATR","qwerty",0);
		cliente.agregarDispositivoEstandar(tv);
		cliente.agregarDispositivoEstandar(aire);
		cliente.persistir();
		List<DispositivoEstandar> dispositivosEstandar = UsuarioService.obtenerDispositivosEstandar("JuanATR","qwerty");
		org.junit.Assert.assertEquals(cliente.getDispositivosEstandares().get(0).getNombre(),dispositivosEstandar.get(0).getNombre());
		org.junit.Assert.assertEquals(cliente.getDispositivosEstandares().get(1).getNombre(),dispositivosEstandar.get(1).getNombre());	
	}
	
	@Test
	public void testObtenerHogares() {
		Cliente cliente = new Cliente("Antonio","Fondevila",TipoIdentificacion.DNI,"321",40539761,"Medrano 951","Toni","loco",0);
	    cliente.persistir();
	    List<Cliente> clientes = UsuarioService.obtenerHogares();
	    Assert.assertTrue(clientes.contains(cliente));
	}
	
}
