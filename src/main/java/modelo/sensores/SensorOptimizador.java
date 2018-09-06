package modelo.sensores;

import modelo.Dispositivo;
import modelo.Optimizador;
import modelo.Sensor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SensorOptimizador extends Sensor {

	@Override
	public void tomarMedicion() {
		Optimizador optimizador = new Optimizador();
		reglas.forEach(regla -> {
			regla.actuadores.forEach(actuador -> {
				List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
				dispositivos.addAll(actuador.dispositivos);
				Map<Dispositivo,Double> mapaConsumo = optimizador.dispositivosYConsumoRecomendado(dispositivos,200D); //mapa de dispositivos/consumoOptimo
				dispositivos.forEach(d -> {
					regla.llamarActuador(d,mapaConsumo.get(d));
				});
			});
		});
	}



}
