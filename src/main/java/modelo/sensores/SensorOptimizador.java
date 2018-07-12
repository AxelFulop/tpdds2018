package modelo.sensores;

import modelo.Dispositivo;
import modelo.Optimizador;
import modelo.Sensor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SensorOptimizador extends Sensor {

	@Override
	public void tomarMedicion() {
		Optimizador optimizador = new Optimizador();
		Dispositivo d = reglas.get(0).;
		Map<Dispositivo,Double> = optimizador.dispositivosYConsumoRecomendado();
		reglas.stream().forEach(r->r.ejecutar(24.5));
	}

}
