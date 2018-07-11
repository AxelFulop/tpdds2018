package modelo;

public abstract class Dispositivo {
public boolean bajoConsumo;
public double kwh;
public Restriccion restriccion;


	public Restriccion getRestriccion() {
		return restriccion;
	}

	public double getConsumoMensual() {
		return 0;
	}
	
	public double getKwh() {
		return kwh;
	}

	public void setKwh(double d) {
		this.kwh = d;
	}
	
	public boolean getBajoConsumo() {
		return bajoConsumo;
	}
	
	public void setBajoConsumo(boolean b) {
		this.bajoConsumo = b;
	}
}
