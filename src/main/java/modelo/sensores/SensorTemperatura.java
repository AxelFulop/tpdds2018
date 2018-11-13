package modelo.sensores;

import modelo.Sensor;
import javax.persistence.Entity;


@Entity
public class SensorTemperatura extends Sensor {
	private double medicion = 24.5d;
	
	@Override
	public void tomarMedicion() {
		reglas.forEach(regla -> {
			regla.getActuador().getDispositivos().forEach(dispositivoInteligente -> {
				regla.llamarActuador(dispositivoInteligente,medicion);
			});
		});
	}

	public Double getMedicion() {
		return medicion;
	}

	public void setMedicion(Double medicion) {
		this.medicion = medicion;
	}	

}
