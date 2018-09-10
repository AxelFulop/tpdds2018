package modelo.sensores;

import modelo.DispositivoInteligente;
import modelo.Sensor;

public class SensorTemperatura extends Sensor {

	@Override
	public void tomarMedicion() {
		reglas.forEach(regla -> {
			regla.getActuador().getDispositivos().forEach(dispositivoInteligente -> {
				regla.llamarActuador(dispositivoInteligente,24.5);
			});
		});
	}

}
