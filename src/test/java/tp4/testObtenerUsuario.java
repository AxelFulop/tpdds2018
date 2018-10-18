package tp4;

import java.util.List;

import org.junit.Test;






import Servicios.AdministradorService;
import Servicios.Session;
import Servicios.UsuarioService;
import modelo.Cliente;
import modelo.DispositivoEstandar;
import modelo.DispositivoInteligente;
import modelo.TipoIdentificacion;
import modelo.Usuario;

public class testObtenerUsuario {
	UsuarioService userService = new UsuarioService();
	AdministradorService admService = new AdministradorService();
	
	@Test
	public void persistoUsuarioYLoObtengo(){
	Cliente cliente3= new Cliente("lucas","rosol",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","luqui","asd",0);
    cliente3.persistir();
    Usuario user = userService.obtenerUsuario("luqui","asd");
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
		List<DispositivoEstandar> dispositivosEstandar = userService.obtenerDispositivosEstandar("JuanATR","qwerty");
		org.junit.Assert.assertEquals(cliente.getDispositivosEstandares().get(0).getNombre(),dispositivosEstandar.get(0).getNombre());
		org.junit.Assert.assertEquals(cliente.getDispositivosEstandares().get(1).getNombre(),dispositivosEstandar.get(1).getNombre());	
	}
	
}
