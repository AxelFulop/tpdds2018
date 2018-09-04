package modelo.sensores;

import modelo.Actuador;
import modelo.DispositivoInteligente;
import modelo.Estado;

public class ActuadorOprtimizadorAhorroEnergia implements Actuador {

	@Override
	public void ejecutarAccion(DispositivoInteligente d) {
		d.setEstado(Estado.AHORROENERGIA);
	}

}