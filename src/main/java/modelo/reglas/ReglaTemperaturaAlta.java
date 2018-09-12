package modelo.reglas;

import modelo.*;
//import org.uqbar.commons.utils.Observable;

import javax.persistence.Entity;

//@Observable
@Entity
public class ReglaTemperaturaAlta extends Regla {

	public ReglaTemperaturaAlta(){

	}
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
