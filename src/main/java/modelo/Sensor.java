package modelo;

import Servicios.Model;
import Servicios.Session;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Sensor extends Model {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
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

    public static Sensor buscarPorId(int id)
    {
        return Session.getSession().find(Sensor.class,id);
    }
    public static List<Sensor> obtenerTodos() {
        return (List<Sensor>) Session.getSession().createQuery("SELECT e FROM Sensor e").getResultList();
    }
    
    public abstract Double getMedicion();
    public abstract void setMedicion(Double m);
    	
}
