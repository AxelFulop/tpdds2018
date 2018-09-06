package modelo.reglas;

import modelo.Actuador;
import modelo.Cliente;
import modelo.DispositivoInteligente;
import modelo.Regla;
import modelo.sensores.ActuadorEncenderAire;

import java.util.List;

public class ReglaTemperaturaAlta extends Regla {

	public ReglaTemperaturaAlta(Cliente c,List<Actuador> actuadores) {
		super(c,actuadores);
	}
	
	@Override
	public void llamarActuador(double temperaturaActual) {

		actuadores.stream().forEach(ac -> {
			if(temperaturaActual > 24.0) {
				ac.ejecutarAccion();
			}
		});


		
	}
}
