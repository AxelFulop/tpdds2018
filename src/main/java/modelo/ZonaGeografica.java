package modelo;

import java.util.ArrayList;
import java.util.List;

public class ZonaGeografica {
public String nombre;
public List<Transformador> transformadores = new ArrayList<Transformador>();

public double getConsumoTotal() {
	return transformadores.stream().mapToDouble(t->t.energiaQueEstaConsumiendo()).sum();
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public List<Transformador> getTransformadores() {
	return transformadores;
}

public void setTransformadores(List<Transformador> transformadores) {
	this.transformadores = transformadores;
}



}
