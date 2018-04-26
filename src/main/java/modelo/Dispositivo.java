package modelo;

import java.util.LinkedHashMap;
import java.util.Map;

public class Dispositivo {
	private String nombre;
	private int kwh;
	private boolean estado;
	private Map<Integer,Double> consumoEnHorasAlMes = new LinkedHashMap<Integer,Double>();
	
	public Dispositivo(String nom, int consumo) {
		nombre = nom;
		kwh = consumo;
		estado = false;
	}
	
	public Double getConsumoEnHorasAlMes(int mes) {
		return consumoEnHorasAlMes.get(mes);
	}

	public void setConsumoEnHorasAlMes(int mes,double d) {
		consumoEnHorasAlMes.put(mes, d);
	}

	
		
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

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
