package modelo;

import org.apache.commons.lang.time.DateUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;
import java.util.Date;

@Entity

@Table(name = "usuario")
public abstract class Usuario {
    @Id
    @GeneratedValue
    private int id;
    protected String nombre;
    protected String apellido;
    protected String nombreUsuario;
    protected String contrasenia;
    protected Date fechaAltaServicio;


    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contrasenia, String nombre, String apellido) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaAltaServicio = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Date getFechaAltaServicio() {
        return fechaAltaServicio;
    }

    public void setFechaAltaServicio(Date fechaAltaServicio) {
        this.fechaAltaServicio = fechaAltaServicio;
    }
}
