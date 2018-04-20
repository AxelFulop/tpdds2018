package modelo;

public class Dispositivo {
	private String nombre;
	private int kwh;
	private boolean estado;
	
	public Dispositivo(String nom, int consumo) {
		nombre = nom;
		kwh = consumo;
		estado = false;
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
