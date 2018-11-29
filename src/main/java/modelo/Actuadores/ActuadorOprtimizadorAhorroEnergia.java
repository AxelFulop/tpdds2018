package modelo.Actuadores;

import modelo.Actuador;
import modelo.DispositivoInteligente;
import modelo.Estado;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class ActuadorOprtimizadorAhorroEnergia extends Actuador {

	public ActuadorOprtimizadorAhorroEnergia(){}
	public ActuadorOprtimizadorAhorroEnergia (List<DispositivoInteligente> dispositivos)
	{
		super(dispositivos);
	}


	@Override
	public void ejecutarAccion(DispositivoInteligente d) { //TODO: Cambiar por dispositivoInteligente;
		dispositivos.forEach(dis ->
		{
			if (d.getNombre() == dis.getNombre())
			{
				d.setEstado(Estado.AHORROENERGIA);
			}
		});
	}

}