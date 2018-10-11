package modelo.Actuadores;

import modelo.Actuador;
import modelo.DispositivoInteligente;
import javax.persistence.Entity;
import java.util.List;

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