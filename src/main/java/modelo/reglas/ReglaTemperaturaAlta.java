package modelo.reglas;

import modelo.*;
import modelo.sensores.ActuadorEncenderAire;

import java.util.List;

public class ReglaTemperaturaAlta extends Regla {

	public ReglaTemperaturaAlta(Actuador actuador) {
		super(actuador);
	}
	
	@Override
	public void llamarActuador(DispositivoInteligente d,double temperaturaActual) {

			if(temperaturaActual > 24.0) {
				actuador.ejecutarAccion(d);
			}


		
	}
}
