package modelo;

//import org.uqbar.commons.utils.Observable;

import javax.persistence.*;

//@Observable
@Entity
@Table(name = "dispositivo")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Dispositivo {
    @Id@GeneratedValue
    private int id;
    public boolean bajoConsumo;
    public double kwh;
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
}
