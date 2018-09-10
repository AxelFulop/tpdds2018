package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class  Sensor {
public List<Regla> reglas = new ArrayList<Regla>();

	public void addRegla(Regla r) {
		reglas.add(r);
	}

	public void tomarMedicion() {
		
	}

	public void EjecutarReglasAsociadas(){
		this.tomarMedicion();
	}
}
