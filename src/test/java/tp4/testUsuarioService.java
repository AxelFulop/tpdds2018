package tp4;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import Servicios.DispositivoService;
import Servicios.SHA256Builder;
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
    UsuarioService.persistir(cliente3);
    Usuario user = UsuarioService.obtenerUsuario("luqui","asd");
    org.junit.Assert.assertEquals(user.getNombreUsuario(),"luqui");
    org.junit.Assert.assertEquals(user.getContrasenia(),SHA256Builder.generarHash256("asd"));
}
	
	@Test
	public void testObtenerDispositivosEstandar()
	{
		DispositivoEstandar tv = new DispositivoEstandar("tv", false,10d);
		tv.persistir();
		DispositivoEstandar aire = new DispositivoEstandar("aire",true,1d);
		aire.persistir();
		Cliente cliente = (Cliente) UsuarioService.obtenerUsuario("trertrer", "popopopo");
		if(cliente == null) { 
			cliente= new Cliente("test","test",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","trertrer", "popopopo",0);
		}
		cliente.agregarDispositivoEstandar(tv);
		cliente.agregarDispositivoEstandar(aire);
		UsuarioService.persistir(cliente);
		
		Cliente c = (Cliente)UsuarioService.obtenerUsuario("trertrer", "popopopo");
		List<DispositivoEstandar> dispositivosEstandar = UsuarioService.obtenerDispositivosEstandarPorId(c.getId());
		org.junit.Assert.assertEquals(cliente.getDispositivosEstandares().get(0).getNombre(),dispositivosEstandar.get(0).getNombre());
		org.junit.Assert.assertEquals(cliente.getDispositivosEstandares().get(1).getNombre(),dispositivosEstandar.get(1).getNombre());	
		UsuarioService.eliminar(cliente);
		for(DispositivoEstandar d:dispositivosEstandar) {
	    	DispositivoService.eliminar(d);
	    }
	}
	
	@Test
	public void testPersistoDispositivos() {
		DispositivoEstandar tv = new DispositivoEstandar("tv", false,10d);
		DispositivoInteligente aire = new DispositivoInteligente("aire", false,15d);
		tv.persistir();
		aire.persistir();
		Cliente cliente = (Cliente) UsuarioService.obtenerUsuario("esaaarecheto", "ahhtr55l");
		if(cliente == null) { 
			cliente= new Cliente("test","test",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","esaaarecheto","ahhtr55l",0);
		}
	    cliente.agregarDispositivoEstandar(tv);
	    cliente.agregarDispositivoInteligente(aire);
		UsuarioService.persistir(cliente);
		
		Cliente c = (Cliente)UsuarioService.obtenerUsuario("esaaarecheto","ahhtr55l");
		List<DispositivoInteligente> disp = UsuarioService.obtenerDispositivosInteligentesPorId(c.getId());
	    Assert.assertNotEquals(disp.get(0), null);
	    
	    UsuarioService.eliminar(c);
	    for(DispositivoInteligente d:disp) {
	    	DispositivoService.eliminar(d);
	    }
	}
	
	@Test
	public void testObtengoDispositivos() {
		DispositivoEstandar tv = new DispositivoEstandar("tv", false,10d);
		DispositivoInteligente aire = new DispositivoInteligente("aire", false,15d);
		tv.persistir();
		aire.persistir();
		Cliente cliente = (Cliente) UsuarioService.obtenerUsuario("Perrunatata","locoadddaa");
		if(cliente == null) { 
			cliente= new Cliente("test","test",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","Perrunatata","locoadddaa",0);
		}	   
		cliente.agregarDispositivoEstandar(tv);
	    cliente.agregarDispositivoInteligente(aire);
		UsuarioService.persistir(cliente);
		
		Cliente c = (Cliente)UsuarioService.obtenerUsuario("Perrunatata","locoadddaa");
		List<Dispositivo> disp = UsuarioService.obtenerDispositivosPorId(c.getId());
	    for(Dispositivo d:disp) {
	    	Assert.assertNotEquals(d, null);
	    }
	    
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
