package modelo.sensores;

import modelo.Actuador;
import modelo.DispositivoInteligente;
import modelo.Regla;
import modelo.Sensor;

public class ReglaTemperaturaAlta extends Regla {

	public ReglaTemperaturaAlta(DispositivoInteligente d) {
		super(d);
	}

	public void ejecutar() {
		Sensor medidorTemperatura = new SensorTemperatura();
		Actuador prenderAire = new ActuadorEncenderAire();
		
		float temperaturaActual = medidorTemperatura.tomarMedicion();
		if(temperaturaActual > 24.0) {
			prenderAire.ejecutarAccion(dispositivo);
		}
		
	}
}
