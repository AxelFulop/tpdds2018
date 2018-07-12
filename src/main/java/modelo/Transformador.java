package modelo;

import java.util.ArrayList;
import java.util.List;

public class Transformador {
public ZonaGeografica zonaGeografica;
public List<Cliente> clientes = new ArrayList<Cliente>();

public double energiaQueEstaConsumiendo() {
	return clientes.stream().mapToDouble(c->c.getConsumoInstantaneo()).sum();
}

public ZonaGeografica getZonaGeografica() {
	return zonaGeografica;
}

public void setZonaGeografica(ZonaGeografica zonaGeografica) {
	this.zonaGeografica = zonaGeografica;
}

public List<Cliente> getClientes() {
	return clientes;
}

public void setClientes(List<Cliente> clientes) {
	this.clientes = clientes;
}

}
