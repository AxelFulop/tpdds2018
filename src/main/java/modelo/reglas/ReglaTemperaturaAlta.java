package modelo.reglas;

import modelo.*;
import javax.persistence.Entity;

@Entity
public class ReglaTemperaturaAlta extends Regla {

	public ReglaTemperaturaAlta(){

	}
	public ReglaTemperaturaAlta(Actuador actuador, String nom) {
		super(actuador, nom);
	}
	
	@Override
	public void llamarActuador(DispositivoInteligente d,double temperaturaActual) {

			if(temperaturaActual > 24.0) {
				actuador.ejecutarAccion(d);
			}


		
	}
}
