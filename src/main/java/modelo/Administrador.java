package modelo;


import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
@Entity
public class Administrador extends Usuario {

	public Administrador(){

	}

	public Administrador(String nombre,String apellido,int numIdentificacion,String nombreUsuario,String contrasenia) {
		super(nombreUsuario,contrasenia,nombre,apellido);
	}
	
	public int candidaDeMesesComoAdministrator() {
		Date todayDate = new Date();
		return (todayDate.getYear() - fechaAltaServicio.getYear()) *12 + todayDate.getMonth();
	}
	
	
}
