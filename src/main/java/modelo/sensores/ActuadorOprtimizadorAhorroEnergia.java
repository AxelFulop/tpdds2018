package modelo.sensores;

import modelo.Actuador;
import modelo.Dispositivo;
import modelo.DispositivoInteligente;
import modelo.Estado;

import java.util.List;

public class ActuadorOprtimizadorAhorroEnergia extends Actuador {

	public ActuadorOprtimizadorAhorroEnergia (List<DispositivoInteligente> dispositivos)
	{
		super(dispositivos);
	}


	@Override
	public void ejecutarAccion(Dispositivo d) { //TODO: Cambiar por dispositivoInteligente;
		dispositivos.forEach(dis ->
		{
			if (d.getName() == dis.getName())
			{
				dis.setEstado(Estado.AHORROENERGIA);
			}
		});
	}

}