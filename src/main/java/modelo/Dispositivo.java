package modelo;

public abstract class Dispositivo {
private boolean bajoConsumo;
public double kwh;

public double getKwh() {
	return kwh;
}

public void setKwh(double d) {
	this.kwh = d;
}

public void setBajoConsumo(boolean b) {
	this.bajoConsumo = b;
}

	public double getConsumoMensual() {
		return 0;
	}

}
