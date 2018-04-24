package modelo;

import java.time.LocalDate;

public class Administrador {
	private String nombre;
	private String apellido;
	private String domicilio;
	private LocalDate fechaDeAlta;
	private int numIdentificacion;
	private String nombreUsuario;
	private String contraseña;
	
	public Administrador(String nombre,String apellido,int numIdentificacion,String nombreUsuario,String contraseña) {
		fechaDeAlta = LocalDate.now();
		this.nombre=nombre;
		this.apellido=apellido;
		this.numIdentificacion=numIdentificacion;
		this.nombreUsuario=nombreUsuario;
		this.contraseña=contraseña;
		
	}

	
	public int cantMesesComoAdmin() {
		return LocalDate.now().compareTo(fechaDeAlta); // MAL, falta implementar este metodo
	}
}
