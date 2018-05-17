package modelo;

import java.util.ArrayList;
import java.util.List;


public class Actuador {
	List<Sensor> sensores = new ArrayList<Sensor>();
	Cliente cliente;
	Sensor sensorTemperatura;
	
	public Actuador (List<Sensor> sensores,Cliente cliente, Sensor sensorTemperatura)
	{
		this.sensores = sensores;
		this.cliente = cliente;
		this.sensorTemperatura = sensorTemperatura;
	}
	//Ejemplo de regla
public void encenderAireSiTemperaturaMayorA(float temperatura){
	float tempSensor = sensorTemperatura.tomarMedicion();
	if(tempSensor > temperatura) {
	cliente.getDispositivosInteligentes().stream()
	.forEach(d-> {if(d.getNombre() == "aireAcondicionado") d.getAdaptadorInteligente().encender();} );
}
}
	
}
