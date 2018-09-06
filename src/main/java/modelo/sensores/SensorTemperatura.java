package modelo.sensores;

import modelo.Sensor;

public class SensorTemperatura extends Sensor {

	@Override
	public void tomarMedicion() {
		reglas.stream().forEach(r->r.llamarActuador(24.5));
	}

}
