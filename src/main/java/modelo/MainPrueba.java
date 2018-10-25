package modelo;

import java.util.List;

import Servicios.UsuarioService;

public class MainPrueba {

	public static void main(String[] args) {
		Cliente cliente1= new Cliente("Juan","Perez",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","luqui","asd",0);
		Cliente cliente2= new Cliente("Juan","Perez",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","pedro","asd",0);
		Cliente cliente3= new Cliente("Juan","Perez",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","tito","asd",0);
	
		DispositivoInteligente aire = new DispositivoInteligente("airePiola",true,1d); 
		DispositivoInteligente heladera = new DispositivoInteligente("heladeraPiola",true,1d); 
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
		
		Cliente c1 = (Cliente) UsuarioService.obtenerUsuario(cliente1.getNombreUsuario(), cliente1.getContrasena());
		System.out.println(c1.toString());
		List<Dispositivo> dispositivos = UsuarioService.obtenerDispositivos(cliente1.getNombreUsuario(), cliente1.getContrasena());
		for(Dispositivo d:dispositivos) {
			System.out.println(d.toString());
		}
	}

}
