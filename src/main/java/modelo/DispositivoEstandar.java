package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
public class DispositivoEstandar extends Dispositivo {
	@Id @GeneratedValue
	private long id;
	private String nombre;
	private int horasDeUsoDiarias; //Estimativo brindado por el usuario
	
	
	public DispositivoEstandar(){}
	
	public DispositivoEstandar(String nom, boolean bajoConsumo, double kwh) {
		setNombre(nom);
		setBajoConsumo(bajoConsumo);
		setKwh(kwh);
	}
	
	public double getConsumoMensual() {
		return (double) (kwh * horasDeUsoDiarias * 30);
	}
	
	//GETTERS Y SETTERS

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHorasDeUsoDiarias() {
		return horasDeUsoDiarias;
	}

	public void setHorasDeUsoDiarias(int horasDeUsoDiarias) {
		this.horasDeUsoDiarias = horasDeUsoDiarias;
	}
	
}
