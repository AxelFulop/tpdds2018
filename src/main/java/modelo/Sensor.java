package modelo;

//import org.uqbar.commons.utils.Observable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Observable
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Sensor {
    @Id
    @GeneratedValue
    private int id;
    @OneToMany
    @JoinColumn(name = "sensor_id")
    public List<Regla> reglas = new ArrayList<Regla>();

    public Sensor(){

    }
    public List<Regla> getReglas() {
        return reglas;
    }

    public void setReglas(List<Regla> reglas) {
        this.reglas = reglas;
    }

    public void addRegla(Regla r) {
        reglas.add(r);
    }

    public void tomarMedicion() {

    }

    public void EjecutarReglasAsociadas() {
        this.tomarMedicion();
    }
}
