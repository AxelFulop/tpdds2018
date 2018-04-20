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
	
	public Administrador() {
		fechaDeAlta = LocalDate.now();
	}
	// dsp asigno los demas parametros
	
	public int cantMesesComoAdmin() {
		return LocalDate.now().compareTo(fechaDeAlta); // MAL, falta implementar este metodo
	}
}
