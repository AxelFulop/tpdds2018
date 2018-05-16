package modelo;

import java.util.LinkedHashMap;
import java.util.Map;

public class Dispositivo {
	private String nombre;
	private int kwh;
	private EstadoDispositivo estado;
	
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
	
	public void encendete()
	{
		estado = new Encendido();
	}
	
	public void apagate()
	{
	 estado = new Apagado();	
	}
	
	public void ahorraEnergia()
	{
	estado = new AhorroEnergia();	
	}
	
}
