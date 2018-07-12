package modelo;

public abstract class Regla {
public Cliente cliente;
public DispositivoInteligente dispositivo;
	
	public Regla (Cliente c,DispositivoInteligente d) {
		this.dispositivo = d;
		this.cliente = c;
	}

public void ejecutar(double medicion) {

}

	
}
