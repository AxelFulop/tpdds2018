package modelo.sensores;

import modelo.Dispositivo;
import modelo.Optimizador;
import modelo.Sensor;

import java.util.List;
import java.util.Map;

public class SensorOptimizador extends Sensor {

	@Override
	public void tomarMedicion() {
		Optimizador optimizador = new Optimizador();
		List<Dispositivo> dispositivosCliente = reglas.get(0).cliente.getDispositivos(); //cliente que conoce la regla
		Dispositivo dispositivoAOptimizar = reglas.get(0).dispositivo; //dispositivo que conoce la regla
		Map<Dispositivo,Double> mapa = optimizador.dispositivosYConsumoRecomendado(dispositivosCliente,130D); //mapa de dispositivos/consumoOptimo
		reglas.stream().forEach(r->r.ejecutar(mapa.get(dispositivoAOptimizar))); //ejecuta sobre la medición optima de cada dispositivo
	}

}
