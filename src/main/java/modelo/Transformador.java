package modelo;

import java.util.ArrayList;
import java.util.List;

public class Transformador {
public ZonaGeografica zonaGeografica;
public List<Cliente> clientes = new ArrayList<Cliente>();

public double energiaQueEstaConsumiendo() {
	return clientes.stream().mapToDouble(c->c.getConsumoInstantaneo()).sum();
}


}
