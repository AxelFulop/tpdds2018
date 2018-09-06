package modelo.sensores;

import modelo.Dispositivo;
import modelo.Sensor;

public class SensorTemperatura extends Sensor {

	public void tomarMedicion(Dispositivo d) {
		reglas.stream().forEach(r->r.llamarActuador(d,24.5));
	}

}
