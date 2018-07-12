package modelo.sensores;

import modelo.Actuador;
import modelo.DispositivoInteligente;
import modelo.Regla;

public class ReglaOptimizadorConsumoAlto extends Regla {

	public ReglaOptimizadorConsumoAlto(DispositivoInteligente d) {
		super(d);
	}
	
	@Override
	public void ejecutar(double consumoDeseado) {

		Actuador actuadorOptimizadorAhorroEnergia = new ActuadorOprtimizadorAhorroEnergia();

		if(dispositivo.getConsumoMensual()>=consumoDeseado) {
			actuadorOptimizadorAhorroEnergia.ejecutarAccion(dispositivo);
		}
		
	}
}
