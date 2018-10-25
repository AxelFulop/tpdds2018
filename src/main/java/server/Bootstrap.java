package server;




import java.util.List;

import Servicios.DispositivoService;
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
import modelo.Restriccion;
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
			Cliente cliente = new Cliente("Juan","Perez",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","pechoFrio","asd",0);
		
			DispositivoInteligente aire = new DispositivoInteligente("dispReCheto",true,1d); 
			DispositivoInteligente heladera = new DispositivoInteligente("heladeraTurra",true,1d);
			/*Restriccion restrAire = new Restriccion();
			restrAire.setCotasAireAcondicionado();
			Restriccion restrHeladera = new Restriccion();
			restrHeladera.setCotasComputadora();
			restrAire.persistir();
			restrHeladera.persistir();*/
			//cliente.agregarDispositivoInteligente(aire);
			//cliente.agregarDispositivoInteligente(heladera);
			//DispositivoService.persistir(aire);
			//DispositivoService.persistir(heladera);
			UsuarioService.persistir(cliente);
			
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