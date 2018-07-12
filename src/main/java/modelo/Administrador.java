package modelo;


import java.time.LocalDate;
import java.time.Period;


public class Administrador {
	private String nombre;
	private String apellido;
	private String domicilio;
	private LocalDate fechaDeAlta;
	private int numIdentificacion;
	private String nombreUsuario;
	private String contrasenia;
	
	public Administrador(String nombre,String apellido,int numIdentificacion,String nombreUsuario,String contrasenia, LocalDate fechaAlta) {
		this.fechaDeAlta = fechaAlta;
		this.nombre=nombre;
		this.apellido=apellido;
		this.numIdentificacion=numIdentificacion;
		this.nombreUsuario=nombreUsuario;
		this.contrasenia=contrasenia;
	}
	
	public int candidaDeMemesComoAdministrator() {
		Period p = Period.between(fechaDeAlta,LocalDate.now());
		return p.getYears() * 12 + p.getMonths();
	}
	
	
}
