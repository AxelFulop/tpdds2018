package modelo;

import java.util.LinkedHashMap;
import java.util.Map;

public class Dispositivo {
	private String nombre;
	private int kwh;
	private int horasEnUsoDelDia = 0;
	private Inteligente adaptadorInteligente; //inteligente o null
	
	public Dispositivo(String nom, int consumo,Inteligente inteligente) {
		nombre = nom;
		kwh = consumo;
		this.adaptadorInteligente = inteligente;
	}
	
	public Inteligente getAdaptadorInteligente() {
		return adaptadorInteligente;
	}

	public void setAdaptadorInteligente(Inteligente adaptadorInteligente) {
		this.adaptadorInteligente = adaptadorInteligente;
	}
		
	public Estado estado() {
		return adaptadorInteligente.getEstado();	
	}
	
	
	public Double getConsumoDeKwMensual() {
		return (double) (kwh * horasEnUsoDelDia * 30);
	}

	public float getHorasEnUsoDelDia() {
		return this.horasEnUsoDelDia;
	}
	public void setHorasEnUsoDelDia(int horas) {
		this.horasEnUsoDelDia = horas;
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
	
	public boolean esInteligente() {
		if (adaptadorInteligente != null) {
			return adaptadorInteligente.esInteligente();
		}
		else {
			return false;
		}
	}
	
	public float energiaConsumidaEnUltimasHoras(int horas) throws Exception{
		return adaptadorInteligente.energiaConsumidaEnUltimasHoras(horas,this);
	} //supongo que el dispositivo no se apaga (MAL)
	
	public float consumoTotalEnPeriodo(int horasInicio, int horasFinal) {
		return adaptadorInteligente.consumoTotalEnPeriodo(horasInicio, horasFinal, this);
	}
	
	public void convertirAInteligente()
	{
		this.adaptadorInteligente = new Inteligente();
	}
	
	
}
