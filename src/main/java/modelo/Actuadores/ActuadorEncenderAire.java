package modelo.Actuadores;

import modelo.Actuador;
import modelo.Dispositivo;
import modelo.DispositivoInteligente;
//import org.uqbar.commons.utils.Observable;

import javax.persistence.Entity;
import java.util.List;

//@Observable
@Entity
public class ActuadorEncenderAire extends Actuador {

	public ActuadorEncenderAire(){}
	public ActuadorEncenderAire(List<DispositivoInteligente> dispositivos)
	{
		super(dispositivos);
	}
	public void ejecutarAccion(DispositivoInteligente d) {
		d.encender();
	}

}