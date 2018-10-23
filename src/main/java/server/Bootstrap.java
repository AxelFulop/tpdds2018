package server;




import modelo.Administrador;
import modelo.Cliente;
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
		clear();
		
		if((UsuarioService.obtenerUsuario("root","root")).equals(null)){
		Usuario root = new Usuario();
		root.setContrasenia("root");
		root.setNombreUsuario("root");
		UsuarioService.persistir(root);
		
		}
		Cliente cliente1 = new Cliente("Antonio","Fondevila",TipoIdentificacion.DNI,"321",40539761,"Medrano 951","Toni","loco",0);
		Cliente cliente2= new Cliente("Juan","Perez",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","JuanATR","qwerty",0);
		Cliente cliente3= new Cliente("Lucas","Carrizo",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","luqui","asd",0);
		if(UsuarioService.obtenerUsuario("JuanATR","qwerty").equals(null) && UsuarioService.obtenerUsuario("Toni","loco").equals(null)
			&& UsuarioService.obtenerUsuario("luqui","asd").equals(null)){
		UsuarioService.persistir(cliente1);
		UsuarioService.persistir(cliente2);
		UsuarioService.persistir(cliente3);
		}
		
		});
	
	}
	
}