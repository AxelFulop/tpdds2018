package modelo.sensores;

import modelo.Sensor;

public class Temperatura implements Sensor {

	int nombreSensor;
	
	public float tomarMedicion() {
		return (float) 24.5;
	}

}
