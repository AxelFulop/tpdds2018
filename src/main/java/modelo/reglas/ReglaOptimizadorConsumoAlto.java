package modelo.reglas;

import modelo.Actuador;
import modelo.Cliente;
import modelo.DispositivoInteligente;
import modelo.Regla;
import modelo.sensores.ActuadorOprtimizadorAhorroEnergia;

public class ReglaOptimizadorConsumoAlto extends Regla {

	public ReglaOptimizadorConsumoAlto(DispositivoInteligente d, Cliente c) {
		super(c,d);
	}
	
	@Override
	public void ejecutar(double consumoDeseado) {

		Actuador actuadorOptimizadorAhorroEnergia = new ActuadorOprtimizadorAhorroEnergia();

		if(dispositivo.getConsumoMensual() >= consumoDeseado) {
			actuadorOptimizadorAhorroEnergia.ejecutarAccion(dispositivo);

		}
		
	}
}
