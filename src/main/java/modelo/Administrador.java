package modelo;


//import org.uqbar.commons.utils.Observable;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import static java.lang.Math.abs;

//@Observable
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
	
	public void eliminarDispositivo (DispositivoInteligente disp)
	{
		EntityManagerFactory d = Persistence.createEntityManagerFactory("db");
        EntityManager em = d.createEntityManager();
        disp = em.find(DispositivoInteligente.class,disp.getId());
        em.remove(disp);
	
	}
	
	public void CrearDispositivoInteligente (DispositivoInteligente disp)
	{
		
		EntityManagerFactory d = Persistence.createEntityManagerFactory("db");
        EntityManager em = d.createEntityManager();
        disp = em.find(DispositivoInteligente.class,disp.getId());
        em.persist(disp);
	
	}
	
	public void modificarDispositivo (DispositivoInteligente disp,String valor, String valorMod)
	{
		EntityManagerFactory d = Persistence.createEntityManagerFactory("db");
        EntityManager em = d.createEntityManager();
        int id = disp.getId();
        disp = em.find(DispositivoInteligente.class,id);
        em.createQuery( "update  DispositivoInteligente d set d  :valo = :valoMod  where d.id = :idd" )
        .setParameter("valo",valor).setParameter("valoMod", valorMod).setParameter("idd", id)
        .setMaxResults(10)
        .getResultList();
	
	}
	
	
	
	
}
