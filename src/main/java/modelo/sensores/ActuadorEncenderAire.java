package modelo.sensores;

import modelo.Actuador;
import modelo.DispositivoInteligente;

public class ActuadorEncenderAire implements Actuador {

	@Override
	public void ejecutarAccion(DispositivoInteligente d) {
		d.encender();
	}

}
