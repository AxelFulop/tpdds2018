package tpCompetencias;

public class Dispositivo {
	private boolean estado;
	private String nombre;
	private float consumo;

	public float getTotalConsumido() {
		return consumo;
	}

	public boolean getEstado() {
		return estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean estaEncendido() {
		return this.getEstado() == true;
	}

	public boolean noEstaEncendido() {
		return this.getEstado() == false;
	}

	public void consumiEnergia(float  Kwh) {
		consumo += Kwh;
	}

}
