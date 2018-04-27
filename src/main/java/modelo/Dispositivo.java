package modelo;

import java.util.LinkedHashMap;
import java.util.Map;

public class Dispositivo {
	private String nombre;
	private int kwh;
	private boolean encendido;
	private Map<Integer,Double> consumoEnHorasAlMes = new LinkedHashMap<Integer,Double>();
	
	public Dispositivo(String nom, int consumo) {
		nombre = nom;
		kwh = consumo;
		encendido = false;
	}
	
	public Double getConsumoDeKwMensual() {
		return (double) (kwh * 30 * 24);
	}

	//Segun la nueva lógica este método no tiene funcionalidad
	/*public void setConsumoEnHorasAlMes(int mes,double d) {
		consumoEnHorasAlMes.put(mes, d);
	}*/
		
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getKwh() {
		return kwh;
	}

	public void setKwh(int kwh) {
		this.kwh = kwh;
	}

	public boolean estaEncendido() {
		return encendido;
	}

	public void encender() {
		this.encendido = true;
	}
	
	public void apagar() {
		this.encendido = false;
	}
	
}
