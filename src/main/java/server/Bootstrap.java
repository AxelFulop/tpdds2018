package server;




import Servicios.SHA256Builder;
import modelo.Administrador;
import modelo.Cliente;
import modelo.DispositivoEstandar;
import modelo.DispositivoInteligente;
import modelo.Estado;
import modelo.TipoIdentificacion;
import modelo.Usuario;

import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import Servicios.UsuarioService;



public class Bootstrap implements WithGlobalEntityManager, EntityManagerOps, TransactionalOps{
	
	public static void main(String[] args) {
		new Bootstrap().init();
	}
	
	public void clear()
	{
		Usuario root = new Usuario();
		root.setContrasenia("root");
		root.setNombreUsuario("root");
		UsuarioService.eliminar(root);
	}
	
	public void init(){
	withTransaction(() ->{
		DispositivoInteligente tv = new DispositivoInteligente("tv", false,10d);
		tv.persistir();
		DispositivoInteligente aire = new DispositivoInteligente("aire",true,1d);
		aire.setEstado(Estado.APAGADO);
		aire.persistir();
		Cliente cliente= new Cliente("test","test",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","pepe","pepe",0);
		cliente.agregarDispositivoInteligente(tv);
		cliente.agregarDispositivoInteligente(aire);
		UsuarioService.persistir(cliente);
		if((UsuarioService.obtenerUsuario("root",SHA256Builder.generarHash256("root"))).equals(null)){
		Usuario root = new Usuario();
		root.setContrasenia(SHA256Builder.generarHash256("root"));
		root.setNombreUsuario("root");
		UsuarioService.persistir(root);
		
		}
		});
	
	}
	
}