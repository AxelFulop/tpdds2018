package modelo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import modelo.repositorios.RepositorioClientes;

public class Administrador {
	private String nombre;
	private String apellido;
	private String domicilio;
	private LocalDate fechaDeAlta;
	private int numIdentificacion;
	private String nombreUsuario;
	private String contraseņa;
	
	public Administrador(String nombre,String apellido,int numIdentificacion,String nombreUsuario,String contraseņa, LocalDate fechaAlta) {
		this.fechaDeAlta = fechaAlta;
		this.nombre=nombre;
		this.apellido=apellido;
		this.numIdentificacion=numIdentificacion;
		this.nombreUsuario=nombreUsuario;
		this.contraseņa=contraseņa;
		
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
