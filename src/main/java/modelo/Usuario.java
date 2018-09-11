package modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id @GeneratedValue
	private int id;
	private String nombre;
	private String contrasenia;
	private LocalDate fechaAltaServicio;
	
	public Usuario(String nom, String contr,LocalDate time) {
		nombre = nom;
		contrasenia = contr;
		fechaAltaServicio = time;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public LocalDate getFechaAltaServicio() {
		return fechaAltaServicio;
	}

	public void setFechaAltaServicio(LocalDate fechaAltaServicio) {
		this.fechaAltaServicio = fechaAltaServicio;
	}
	
	
}
