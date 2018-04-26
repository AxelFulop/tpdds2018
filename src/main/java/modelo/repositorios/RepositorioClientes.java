package modelo.repositorios;

import java.util.List;

import modelo.Cliente;

public class RepositorioClientes {
	
	public static RepositorioClientes instancia = new RepositorioClientes();
	public static List<Cliente> clientes;
	
	private RepositorioClientes() { }

	public static RepositorioClientes getInstancia() {
		return instancia;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void addCliente(Cliente cliente) {
		RepositorioClientes.clientes.add(cliente);
	}	
}
