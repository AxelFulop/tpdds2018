package modelo.sensores;

import modelo.Actuador;
import modelo.DispositivoInteligente;
import modelo.Regla;

public class ReglaTemperaturaAlta extends Regla {

	public ReglaTemperaturaAlta(DispositivoInteligente d) {
		super(d);
	}
	
	@Override
	public void ejecutar(double temperaturaActual) {

		Actuador prenderAire = new ActuadorEncenderAire();

		if(temperaturaActual > 24.0) {
			prenderAire.ejecutarAccion(dispositivo);
		}
		
	}
}
