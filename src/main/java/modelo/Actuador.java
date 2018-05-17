package modelo;

import java.util.ArrayList;
import java.util.List;


public class Actuador {
	Cliente cliente;
	Sensor sensorTemperatura;
	
	public Actuador (Cliente cliente, Sensor sensorTemperatura)
	{
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
