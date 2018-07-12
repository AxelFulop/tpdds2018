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
		List<Dispositivo> dispositivosCliente = reglas.get(0).cliente.getDispositivos();
		Dispositivo dispositivoAOptimizar = reglas.get(0).dispositivo;
		Map<Dispositivo,Double> mapa= optimizador.dispositivosYConsumoRecomendado(dispositivosCliente,130D);
		reglas.stream().forEach(r->r.ejecutar(mapa.get(dispositivoAOptimizar)));
	}

}
