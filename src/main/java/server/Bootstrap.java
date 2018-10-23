package server;




import modelo.Administrador;
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
	
	public void init(){
	withTransaction(() ->{
		if(UsuarioService.obtenerUsuario("root","root")==null)
		{
			Usuario root = new Usuario();
			root.setContrasenia("root");
			root.setNombreUsuario("root");
			UsuarioService.persistir(root);
		}

		});
	}
	
}