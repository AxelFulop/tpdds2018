package server;




import java.util.List;

import Servicios.Parser;
import Servicios.SHA256Builder;
import modelo.Actuador;
import modelo.Administrador;
import modelo.Cliente;
import modelo.DispositivoEstandar;
import modelo.DispositivoInteligente;
import modelo.Estado;
import modelo.Optimizador;
import modelo.Regla;
import modelo.Sensor;
import modelo.TipoIdentificacion;
import modelo.Usuario;
import modelo.sensores.SensorOptimizador;

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
		try {
			Sensor sensorOptimizador = new SensorOptimizador();
			Actuador actuadorOptimizador ;
			Regla reglaApagadoOptimizacion;
			Optimizador optimizador = new Optimizador();
			
			Cliente cliente1= new Cliente("Juan","Perez",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","lucas","asd",0);
			Cliente cliente2= new Cliente("Juan","Perez",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","pedro","asd",0);
			Cliente cliente3= new Cliente("Juan","Perez",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","tito","asd",0);
		
			DispositivoInteligente aire = new DispositivoInteligente("aire",true,1d); 
			DispositivoInteligente heladera = new DispositivoInteligente("heladera",true,1d); 
			cliente1.agregarDispositivoInteligente(aire);
			cliente1.agregarDispositivoInteligente(heladera);
			cliente2.agregarDispositivoInteligente(aire);
			cliente2.agregarDispositivoInteligente(heladera);
			cliente3.agregarDispositivoInteligente(aire);
			cliente3.agregarDispositivoInteligente(heladera);
			aire.persistir();
			heladera.persistir();
			UsuarioService.persistir(cliente1);
			UsuarioService.persistir(cliente2);
			UsuarioService.persistir(cliente3);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if((UsuarioService.obtenerUsuario("root",SHA256Builder.generarHash256("root"))) == null){
			Usuario root = new Usuario();
			root.setContrasenia(SHA256Builder.generarHash256("root"));
			root.setNombreUsuario("root");
			UsuarioService.persistir(root);
		
		}
		});
	
	}
	
}