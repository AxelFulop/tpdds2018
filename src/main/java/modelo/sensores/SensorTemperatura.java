package modelo.sensores;

import modelo.Sensor;
import javax.persistence.Entity;
import javax.persistence.Transient;


@Entity
public class SensorTemperatura extends Sensor {
	private double ultimaMedicion = 24.5d;
	
	@Override
	public void tomarMedicion() {
		reglas.forEach(regla -> {
			regla.getActuador().getDispositivos().forEach(dispositivoInteligente -> {
				regla.llamarActuador(dispositivoInteligente, ultimaMedicion);
			});
		});
	}

	public Double getMedicion() {
		return ultimaMedicion;
	}

	public void setMedicion(Double medicion) {
		this.ultimaMedicion = medicion;
	}	

}
