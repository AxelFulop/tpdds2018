package modelo;


import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import static java.lang.Math.abs;

@Entity
public class Administrador extends Usuario {

	public Administrador(){

	}

	public Administrador(String nombre,String apellido,String nombreUsuario,String contrasenia,TipoIdentificacion tipoIdentificacion,String numeroIdentificacion) {
		super(nombreUsuario,contrasenia,nombre,apellido,tipoIdentificacion,numeroIdentificacion);
	}
	
	public int candidaDeMesesComoAdministrator() {
		Date todayDate = new Date();
		return (todayDate.getYear() - fechaAltaServicio.getYear()) *12 + abs(todayDate.getMonth()-fechaAltaServicio.getMonth());
	}
	
	
}
