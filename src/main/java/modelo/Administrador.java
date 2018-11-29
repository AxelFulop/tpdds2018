package modelo;

import Servicios.Session;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

import static java.lang.Math.abs;

@Entity
public class Administrador extends Usuario {

    public Administrador() {

    }

    public Administrador(String nombre, String apellido, String nombreUsuario, String contrasenia, TipoIdentificacion tipoIdentificacion, String numeroIdentificacion) {
        super(nombreUsuario, contrasenia, nombre, apellido, tipoIdentificacion, numeroIdentificacion);
    }

    public int candidaDeMesesComoAdministrator() {
        Date todayDate = new Date();
        return (todayDate.getYear() - fechaAltaServicio.getYear()) * 12 + abs(todayDate.getMonth() - fechaAltaServicio.getMonth());
    }

    public void agregarNuevoDispositoAlSistema(DispositivoInteligente dispositivo) {
        try {
            dispositivo.persistir();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarDispositoDelSistema(DispositivoInteligente dispositivo) {
        try {
            dispositivo.eliminar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificarDispositoDelSistema(DispositivoInteligente dispositivo) {
        try {
            dispositivo.actualizar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Administrador buscarPorId(int id) {
        return Session.getSession().find(Administrador.class, id);
    }

    public static List<Administrador> obtenerTodos() {
        return Session.getSession().createQuery("SELECT e FROM Administrador e").getResultList();
    }


}
