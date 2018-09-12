package modelo;


//import org.uqbar.commons.utils.Observable;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

//@Observable
@Entity

@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Usuario {
    @Id
    @GeneratedValue
    private int id;
    protected String nombre;
    protected String apellido;
    protected String nombreUsuario;
    protected String contrasenia;
    protected Date fechaAltaServicio;
    @Embedded
    protected Identificacion identificacion;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contrasenia, String nombre, String apellido,TipoIdentificacion tipoIdentificacion,String numeroIdentificacion) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaAltaServicio = new Date();
        this.identificacion = new Identificacion(tipoIdentificacion,numeroIdentificacion);

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
