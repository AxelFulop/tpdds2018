package modelo.sensores;

import modelo.Dispositivo;
import modelo.Optimizador;
import modelo.Sensor;
//import org.uqbar.commons.utils.Observable;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//@Observable
@Entity
public class SensorOptimizador extends Sensor {

	@Override
	public void tomarMedicion() {
		Optimizador optimizador = new Optimizador();
		reglas.forEach(regla -> {
				List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
				dispositivos.addAll(regla.getActuador().getDispositivos());
				Map<Dispositivo,Double> mapaConsumo = optimizador.dispositivosYConsumoRecomendado(dispositivos,200D); //mapa de dispositivos/consumoOptimo
			regla.getActuador().getDispositivos().forEach(d -> {
					regla.llamarActuador(d,mapaConsumo.get(d));
				});
			});
	}



}
