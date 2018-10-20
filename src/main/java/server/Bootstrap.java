package server;




import modelo.Administrador;
import modelo.TipoIdentificacion;
import modelo.Usuario;

import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;



public class Bootstrap implements WithGlobalEntityManager, EntityManagerOps, TransactionalOps{
	
	public static void main(String[] args) {
		new Bootstrap().init();
	}
	
	public void init(){
	withTransaction(() ->{
		Administrador admin = new Administrador();
		if(admin.equals(null)){
		 admin = new Administrador("root","root","Pedro","Fuentes",TipoIdentificacion.DNI,"123");
		admin.persistir();
		}	
		});
	}
	
}