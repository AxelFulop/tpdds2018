package common;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Coordenada {
	@Column(name = "coordenadaX")
	private Double x;
	@Column(name = "coordenadaY")
	private Double y;

	public Coordenada(){

	}

	public Coordenada(Double a, Double b){
		this.x = a;
		this.y = b;
	}


	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}
}