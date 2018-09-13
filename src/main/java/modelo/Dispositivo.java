package modelo;

//import org.uqbar.commons.utils.Observable;

import Servicios.Controller;
import Servicios.Session;

import javax.persistence.*;
import java.util.List;

//@Observable
@Entity
@Table(name = "dispositivo")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Dispositivo extends Controller {
    @Id
    @TableGenerator(
            name = "tipoDispositivoIdGenerator",
            table = "tipoDispositivoIdGenerator",
            pkColumnName = "name",
            valueColumnName = "sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tipoDispositivoIdGenerator")
    public int id;
    public boolean bajoConsumo;
    public double kwh;
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(cascade = CascadeType.ALL)
    public Restriccion restriccion;


    public Dispositivo() {

    }

    public double getConsumoInstantaneo() {
        return 1;
    }

    public Restriccion getRestriccion() {
        return restriccion;
    }

    public void setRestriccion(Restriccion restriccion) {
        this.restriccion = restriccion;
    }

    public double getConsumoMensual() {
        return 0;
    }

    public double getKwh() {
        return kwh;
    }

    public void setKwh(double d) {
        this.kwh = d;
    }

    public boolean getBajoConsumo() {
        return bajoConsumo;
    }

    public void setBajoConsumo(boolean b) {
        this.bajoConsumo = b;
    }


    public static Dispositivo buscarPorId(int id)
    {
        return Session.getSession().find(Dispositivo.class,id);
    }
    public static List<Dispositivo> obtenerTodos() {
        return Session.getSession().createQuery("SELECT e FROM Dispositivo e").getResultList();
    }

}
