package modelo;

import java.util.LinkedHashMap;
import java.util.Map;

public class Dispositivo {
	private String nombre;
	private int kwh;
	
	AdaptadorInteligente adaptadorInteligente;
	
	public Dispositivo(String nom, int consumo) {
		nombre = nom;
		kwh = consumo;
		this.adaptadorInteligente = null;
	}
	
	public Double getConsumoDeKwMensual() {
		return (double) (kwh * 30 * 24);
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

	
	public void convertirAInteligente()
	{
		this.adaptadorInteligente = new AdaptadorInteligente();
	}

	public AdaptadorInteligente getAdaptadorInteligente() {
		return adaptadorInteligente;
	}
	
}
