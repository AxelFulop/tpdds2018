package modelo;

import java.util.ArrayList;
import java.util.List;

public class ZonaGeografica {
public String nombre;
public List<Transformador> transformadores = new ArrayList<Transformador>();

public double getConsumoTotal() {
	return transformadores.stream().mapToDouble(t->t.energiaQueEstaConsumiendo()).sum();
}

}
