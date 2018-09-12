package repositorios;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

public final class RepositorioClientes {
	private static List<Cliente> clientes = new ArrayList<Cliente>();

	public static List<Cliente> getClientes() {
		return clientes;
	}

	public static void addCliente(Cliente cliente) {
		RepositorioClientes.clientes.add(cliente);
	}	
}
