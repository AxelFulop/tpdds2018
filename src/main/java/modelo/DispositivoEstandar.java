package modelo;

import javax.persistence.Entity;

@Entity
public class DispositivoEstandar extends Dispositivo {
	private int horasDeUsoDiarias; //Estimativo brindado por el usuario
	
	
	public DispositivoEstandar(){}
	
	public DispositivoEstandar(String nom, boolean bajoConsumo, Double kwh) {
		setNombre(nom);
		setBajoConsumo(bajoConsumo);
		setKwh(kwh);
	}
	
	public Double getConsumoMensual() {	
		return Double.valueOf(kwh * horasDeUsoDiarias * 30); 
	}
	
	//GETTERS Y SETTERS
	public int getHorasDeUsoDiarias() {
		return horasDeUsoDiarias;
	}

	public void setHorasDeUsoDiarias(int horasDeUsoDiarias) {
		this.horasDeUsoDiarias = horasDeUsoDiarias;
	}

	@Override
	public String toString() {
		return "DispositivoEstandar [nombre=" + nombre + ", horasDeUsoDiarias=" + horasDeUsoDiarias +
				", id=" + id + ", bajoConsumo=" + bajoConsumo +
				", kwh=" + kwh + "]";
	}
	
	
}
