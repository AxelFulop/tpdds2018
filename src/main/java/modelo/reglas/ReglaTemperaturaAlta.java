package modelo.reglas;

import modelo.*;
import modelo.sensores.ActuadorEncenderAire;

import java.util.List;

public class ReglaTemperaturaAlta extends Regla {

	public ReglaTemperaturaAlta(List<Actuador> actuadores) {
		super(actuadores);
	}
	
	@Override
	public void llamarActuador(Dispositivo d,double temperaturaActual) {

		actuadores.stream().forEach(ac -> {
			if(temperaturaActual > 24.0) {
				ac.ejecutarAccion(d);
			}
		});


		
	}
}
