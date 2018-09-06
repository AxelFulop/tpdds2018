package modelo.sensores;

import modelo.Actuador;
import modelo.DispositivoInteligente;
import modelo.Estado;

import java.util.List;

public class ActuadorOprtimizadorAhorroEnergia extends Actuador {

	public ActuadorOprtimizadorAhorroEnergia (List<DispositivoInteligente> dispositivos)
	{
		super(dispositivos);
	}


	public void ejecutarAccion() {
		dispositivos.forEach(d -> d.setEstado(Estado.AHORROENERGIA));
	}

}