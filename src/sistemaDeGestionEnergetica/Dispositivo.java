package sistemaDeGestionEnergetica;

public class Dispositivo {
	private String nombre;
	private int kWh;
	private boolean encendido;
	
	public Dispositivo(String nom, int consumo) {
		nombre = nom;
		kWh = consumo;
		encendido = false;
	}
	
	public String nombre() {
		return this.nombre;
	}
	
	public int consumokWh() {
		return this.kWh;
	}

	public boolean estaEncendido() {
		return this.encendido;
	}
	
	public void encender() {
		this.encendido = true;
	}
	
	public void apagar() {
		this.encendido = false;
	}
}
