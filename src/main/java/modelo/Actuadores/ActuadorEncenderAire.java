package modelo.Actuadores;

import modelo.Actuador;
import modelo.DispositivoInteligente;
import javax.persistence.Entity;

import Servicios.Session;

import java.util.List;

@Entity
public class ActuadorEncenderAire extends Actuador {

	public ActuadorEncenderAire(){}
	public ActuadorEncenderAire(List<DispositivoInteligente> dispositivos)
	{
		super(dispositivos);
	}
	public void ejecutarAccion(DispositivoInteligente d) {
		Session.getSession().find(DispositivoInteligente.class, d.getId());
		try {
			Session.beginTransaction();
			d.encender();
			Session.commitTransaction();
		}catch(Exception e) {
			e.printStackTrace();
			Session.rollbackTransaction();
		}
	}

}