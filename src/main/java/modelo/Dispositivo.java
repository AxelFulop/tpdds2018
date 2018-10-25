package modelo;

import Servicios.Model;
import Servicios.Session;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dispositivo")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Dispositivo extends Model {
    @Override
	public String toString() {
		return "Dispositivo [id=" + id + ", bajoConsumo=" + bajoConsumo + ", kwh=" + kwh + ", restriccion="
				+ restriccion + "]";
	}

	@Id
    @TableGenerator(
            name = "tipoDispositivoIdGenerator",
            table = "tipoDispositivoIdGenerator",
            pkColumnName = "name",
            valueColumnName = "sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tipoDispositivoIdGenerator")
    public Long id;
    public boolean bajoConsumo;
    public Double kwh;
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(cascade = CascadeType.ALL)
    public Restriccion restriccion;


    public Dispositivo() {

    }

    public Double getConsumoInstantaneo() {
        return 1d;
    }

    public Restriccion getRestriccion() {
        return restriccion;
    }

    public void setRestriccion(Restriccion restriccion) {
        this.restriccion = restriccion;
    }

    public Double getConsumoMensual() {
        return 0d;
    }

    public Double getKwh() {
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
