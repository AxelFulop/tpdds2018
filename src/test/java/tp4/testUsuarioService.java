package tp4;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import Servicios.DispositivoService;
import Servicios.Session;
import Servicios.UsuarioService;
import modelo.Cliente;
import modelo.Dispositivo;
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
	public void testPersistoDispositivos() {
		DispositivoEstandar tv = new DispositivoEstandar("tv", false,10d);
		DispositivoInteligente aire = new DispositivoInteligente("aire", false,15d);
		Cliente cliente = new Cliente("Antonio","Fondevila",TipoIdentificacion.DNI,"321",40539761,"Medrano 951","Perruna","loco",0);
	    cliente.agregarDispositivoEstandar(tv);
	    cliente.agregarDispositivoInteligente(aire);
		cliente.persistir();
		
		Cliente c = (Cliente)UsuarioService.obtenerUsuario(cliente.getNombreUsuario(), cliente.getContrasena());
		List<DispositivoInteligente> disp = UsuarioService.obtenerDispositivosInteligentes(cliente.getNombreUsuario(), cliente.getContrasena());
	    Assert.assertEquals(disp.size(), 1);
	    
	    UsuarioService.eliminar(c);
	    for(DispositivoInteligente d:disp) {
	    	DispositivoService.eliminar(d);
	    }
	}
	
	@Test
	public void testObtengoDispositivos() {
		DispositivoEstandar tv = new DispositivoEstandar("tv", false,10d);
		DispositivoInteligente aire = new DispositivoInteligente("aire", false,15d);
		Cliente cliente = new Cliente("Antonio","Fondevila",TipoIdentificacion.DNI,"321",40539761,"Medrano 951","Perruna","loco",0);
	    cliente.agregarDispositivoEstandar(tv);
	    cliente.agregarDispositivoInteligente(aire);
		cliente.persistir();
		
		Cliente c = (Cliente)UsuarioService.obtenerUsuario(cliente.getNombreUsuario(), cliente.getContrasena());
		List<Dispositivo> disp = UsuarioService.obtenerDispositivos(cliente.getNombreUsuario(), cliente.getContrasena());
	    Assert.assertEquals(disp.size(), 2);
	    
	    UsuarioService.eliminar(c);
	    for(Dispositivo d:disp) {
	    	DispositivoService.eliminar(d);
	    }
	}
	
	@Test
	public void testObtenerHogares() {
		Cliente cliente = new Cliente("Antonio","Fondevila",TipoIdentificacion.DNI,"321",40539761,"Medrano 951","Toni","loco",0);
	    cliente.persistir();
	    List<Cliente> clientes = UsuarioService.obtenerHogares();
	    Assert.assertTrue(clientes.contains(cliente));
	}
	
	@Test
	public void testObtenerClientePorID() {
		Usuario cliente = UsuarioService.obtenerUsuarioPorId(Long.valueOf("1"));
	    Assert.assertEquals(cliente.getId(), Long.valueOf("1"));
	}
	
}
