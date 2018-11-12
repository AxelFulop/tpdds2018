package server;

import Servicios.SHA256Builder;
import modelo.Cliente;
import modelo.DispositivoEstandar;
import modelo.DispositivoInteligente;
import modelo.Restriccion;
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
		try {
			if((UsuarioService.obtenerUsuario("marcelo","altacontra") == null
				&& UsuarioService.obtenerUsuario("pedrito","piola") == null
				&& UsuarioService.obtenerUsuario("lionel","messi") == null) ){
				
			Cliente cliente1= new Cliente("David","Villa",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","david","altacontra",0);
			Cliente cliente2= new Cliente("Gustavo","Ceratti",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","gustavo","piolin",0);
			Cliente cliente3= new Cliente("Sergio","Aguero",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","kun","gordita",0);
		
			DispositivoInteligente aire = new DispositivoInteligente("aire",false,6d); 
			DispositivoInteligente compu = new DispositivoInteligente("computadora",true,2d); 
			DispositivoInteligente lampara = new DispositivoInteligente("lampara",true,4d);
			DispositivoInteligente microondas = new DispositivoInteligente("microondas",true,4d);
			DispositivoEstandar est1 = new DispositivoEstandar("parlante", false, 5d);
			DispositivoEstandar est2 = new DispositivoEstandar("batidor", true, 3d);
			DispositivoEstandar est3 = new DispositivoEstandar("licuadora", true, 3d);
			
			aire.setConsumoMensual(10d);
			compu.setConsumoMensual(13d);
			lampara.setConsumoMensual(7d);
			microondas.setConsumoMensual(5d);
			
			Restriccion restriccionAire = new Restriccion();
			restriccionAire.setCotasAireAcondicionado();
			aire.setRestriccion(restriccionAire);
			Restriccion restriccionCompu = new Restriccion();
			restriccionCompu.setCotasComputadora();
			compu.setRestriccion(restriccionCompu);
			Restriccion restriccionLampara = new Restriccion();
			restriccionLampara.setCotasLampara();
			lampara.setRestriccion(restriccionLampara);
			Restriccion restriccionMicroondas = new Restriccion();
			restriccionMicroondas.setCotasLampara();
			microondas.setRestriccion(restriccionMicroondas);
			
			est1.setRestriccion(restriccionCompu);
			est2.setRestriccion(restriccionAire);
			est3.setRestriccion(restriccionLampara);
			
			aire.persistir();
			compu.persistir();
			lampara.persistir();
			microondas.persistir();
			est1.persistir();
			est2.persistir();
			est3.persistir();
			
			cliente1.agregarDispositivoInteligente(aire);
			cliente1.agregarDispositivoEstandar(est1);
			cliente2.agregarDispositivoInteligente(compu);
			cliente2.agregarDispositivoEstandar(est2);
			cliente3.agregarDispositivoInteligente(lampara);
			cliente3.agregarDispositivoInteligente(microondas);
			
			UsuarioService.persistir(cliente1);
			UsuarioService.persistir(cliente2);
			UsuarioService.persistir(cliente3);
			}
			
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