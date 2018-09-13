import modelo.Dispositivo;
import modelo.DispositivoInteligente;
import modelo.TipoIdentificacion;
import modelo.Usuario;
import repositorios.RepositorioClientes;

import javax.persistence.*;
import java.util.Date;

import static java.lang.Math.abs;

//@Observable
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

    public void eliminarDispositivo(Dispositivo disp) {
        try {
            Session.beginTransaction();
            Session.getSession().remove(disp);
            Session.closeTransaction();
            RepositorioClientes.eliminarDispositivoDeClientes(disp);
        } catch (Exception e) {
            e.printStackTrace();
            Session.rollbackTransaction();
        }
        em.close();
    }

    public void CrearDispositivoInteligente(DispositivoInteligente disp) {
        try {
            Session.beginTransaction();
            Session.getSession().persist(disp);
            Session.closeTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            Session.rollbackTransaction();
        }
    }

    public void modificarDispositivo(DispositivoInteligente disp) {
        try {
            Session.beginTransaction();
            Session.getSession().merge(disp);
            Session.closeTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            Session.rollbackTransaction();
        }
    }

}
