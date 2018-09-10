package modelo.sensores;

import modelo.Actuador;
import modelo.Dispositivo;
import modelo.DispositivoInteligente;

import java.util.List;

public class ActuadorEncenderAire extends Actuador {

	public ActuadorEncenderAire(List<DispositivoInteligente> dispositivos)
	{
		super(dispositivos);
	}
	public void ejecutarAccion(DispositivoInteligente d) {
		d.encender();
	}

}