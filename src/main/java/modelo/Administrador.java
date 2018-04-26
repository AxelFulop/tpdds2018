package modelo;

import java.io.IOException;
import java.time.LocalDate;

import modelo.repositorios.RepositorioClientes;

public class Administrador {
	private String nombre;
	private String apellido;
	private String domicilio;
	private LocalDate fechaDeAlta;
	private int numIdentificacion;
	private String nombreUsuario;
	private String contraseña;
	
	public Administrador(String nombre,String apellido,int numIdentificacion,String nombreUsuario,String contraseña, String fechaAlta) {
		this.fechaDeAlta = LocalDate.parse(fechaAlta);
		this.nombre=nombre;
		this.apellido=apellido;
		this.numIdentificacion=numIdentificacion;
		this.nombreUsuario=nombreUsuario;
		this.contraseña=contraseña;
		
	}

	public void agregarClienteAlRepo(Cliente cliente) {
		RepositorioClientes.getInstance();
		RepositorioClientes.addCliente(cliente);
	}
	
	public void agregarClienteAlRepoViaJson(String ruta) throws IOException {
		Parser parser = new Parser();
		Cliente cliente = parser.parsearCliente(ruta);
		agregarClienteAlRepo(cliente);
	}
	
	public int cantMesesComoAdmin() {
		LocalDate actual= LocalDate.now();
		int respuesta;
		if(actual.getDayOfMonth()< fechaDeAlta.getDayOfMonth()){
		respuesta = actual.getMonthValue() - fechaDeAlta.getMonthValue() + (actual.getYear()- fechaDeAlta.getYear())*12 - 1;}
		else{
		respuesta =actual.getMonthValue() - fechaDeAlta.getMonthValue() + (actual.getYear()- fechaDeAlta.getYear())*12;	
		}
		return respuesta;
	}
	
	
}
