package modelo;

public class Categorizador {
	
	public void categorizarClientes() {
		
	}
	
	public double facturaMensualDe(Cliente unCliente)
	{
	return unCliente.getCategoria().cargoFijo() + unCliente.getCategoria().cargoVariable() * unCliente.consumoDeLosEncendidos();	
	}
		
}
