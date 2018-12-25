package server;

import modelo.Cliente;
import modelo.DispositivoEstandar;
import modelo.DispositivoInteligente;
import modelo.Restriccion;
import modelo.Sensor;
import modelo.TipoIdentificacion;
import modelo.Usuario;
import modelo.Actuadores.ActuadorEncenderAire;
import modelo.reglas.ReglaTemperaturaAlta;
import modelo.sensores.SensorTemperatura;

import java.util.List;

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
			
			if((UsuarioService.obtenerUsuario("lionel","eldiez") == null
				&& UsuarioService.obtenerUsuario("fuerte","apache") == null
				&& UsuarioService.obtenerUsuario("el","loco") == null) ){
				
			Cliente cliente1= new Cliente("Lionel","Messi",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","lionel","eldiez",0);
			Cliente cliente2= new Cliente("Carlitos","Tevez",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","fuerte","apache",0);
			Cliente cliente3= new Cliente("Marcelo","Bielsa",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","el","loco",0);
		
			DispositivoInteligente aire = new DispositivoInteligente("aire",false,6d); 
			DispositivoInteligente compu = new DispositivoInteligente("computadora",true,2d); 
			DispositivoInteligente aire1 = new DispositivoInteligente("aire",true,4d);
			DispositivoInteligente microondas = new DispositivoInteligente("microondas",true,4d);
			DispositivoInteligente tele = new DispositivoInteligente("television",true,5d);
			DispositivoInteligente aire2 = new DispositivoInteligente("aire",false,8d);
			DispositivoEstandar est1 = new DispositivoEstandar("parlante", false, 5d);
			DispositivoEstandar est2 = new DispositivoEstandar("batidor", true, 3d);
			DispositivoEstandar est3 = new DispositivoEstandar("licuadora", true, 3d);
			
			aire.apagar();
			aire1.apagar();
			aire2.apagar();
			
			aire.setConsumoMensual(5d);
			compu.setConsumoMensual(13d);
			aire1.setConsumoMensual(4d);
			microondas.setConsumoMensual(2d);
			aire2.setConsumoMensual(15d);
			tele.setConsumoMensual(6d);
			
			est1.setHorasDeUsoDiarias(2);
			est2.setHorasDeUsoDiarias(3);
			est3.setHorasDeUsoDiarias(4);
			
			Restriccion restriccionAire = new Restriccion();
			restriccionAire.setCotasAireAcondicionado();
			aire.setRestriccion(restriccionAire);//
			Restriccion restriccionCompu = new Restriccion();
			restriccionCompu.setCotasComputadora();
			compu.setRestriccion(restriccionCompu);//
			Restriccion restriccionLampara = new Restriccion();
			restriccionLampara.setCotasLampara();
			aire1.setRestriccion(restriccionLampara);//
			Restriccion restriccionMicroondas = new Restriccion();
			restriccionMicroondas.setCotasLampara();
			microondas.setRestriccion(restriccionMicroondas);//
			Restriccion restriccionTele = new Restriccion();
			restriccionTele.setCotasTelevisor();
			tele.setRestriccion(restriccionTele);//
			Restriccion restriccionHeladera = new Restriccion();
			restriccionHeladera.setCotasPlancha();
			aire2.setRestriccion(restriccionHeladera);//
			
			est1.setRestriccion(restriccionCompu);
			est2.setRestriccion(restriccionAire);
			est3.setRestriccion(restriccionLampara);
			
			SensorTemperatura sensor1 = new SensorTemperatura();
			SensorTemperatura sensor2 = new SensorTemperatura();
			SensorTemperatura sensor3 = new SensorTemperatura();
			
			aire.persistir();
			compu.persistir();
			aire1.persistir();
			microondas.persistir();
			aire2.persistir();
			tele.persistir();
			est1.persistir();
			est2.persistir();
			est3.persistir();
			
			cliente1.agregarDispositivoInteligente(aire);
			cliente1.agregarDispositivoEstandar(est1);
			cliente1.agregarDispositivoInteligente(tele);
			cliente2.agregarDispositivoInteligente(compu);
			cliente2.agregarDispositivoEstandar(est2);
			cliente2.agregarDispositivoInteligente(aire2);
			cliente3.agregarDispositivoInteligente(aire1);
			cliente3.agregarDispositivoInteligente(microondas);
			cliente3.agregarDispositivoEstandar(est3);
			
			ActuadorEncenderAire act1 = new ActuadorEncenderAire(cliente1.getDispositivosInteligentes());
			ActuadorEncenderAire act2 = new ActuadorEncenderAire(cliente2.getDispositivosInteligentes());
			ActuadorEncenderAire act3 = new ActuadorEncenderAire(cliente3.getDispositivosInteligentes());
			
			ReglaTemperaturaAlta regla1 = new ReglaTemperaturaAlta(act1, "temperatura maxima");
			ReglaTemperaturaAlta regla2 = new ReglaTemperaturaAlta(act2, "temperatura alta");
			ReglaTemperaturaAlta regla3 = new ReglaTemperaturaAlta(act3, "temperatura elevada");
			
			sensor1.addRegla(regla1);
			sensor2.addRegla(regla2);
			sensor3.addRegla(regla3);
			
			sensor1.persistir();
			sensor2.persistir();
			sensor3.persistir();
			
			cliente1.addSensor(sensor1);
			cliente2.addSensor(sensor2);
			cliente3.addSensor(sensor3);
			
			UsuarioService.persistir(cliente1);
			UsuarioService.persistir(cliente2);
			UsuarioService.persistir(cliente3);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if((UsuarioService.obtenerUsuario("root", "root")) == null){
			Usuario root = new Usuario();
			root.setContrasenia("root");
			root.setNombreUsuario("root");
			root.setNombre("Carlos");
			UsuarioService.persistir(root);
		
		}
		});
	
	}
	
}
