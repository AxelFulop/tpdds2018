package modelo;

import org.uqbar.commons.utils.Observable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Observable
@Entity
public class ZonaGeografica {
    @Id
    @GeneratedValue
    public int id;
    public String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ZonaGeografica(){
        
    }

    public List<Transformador> transformadores = new ArrayList<Transformador>();

    public double getConsumoTotal() {
        return transformadores.stream().mapToDouble(t -> t.energiaQueEstaConsumiendo()).sum();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Transformador> getTransformadores() {
        return transformadores;
    }

    public void setTransformadores(List<Transformador> transformadores) {
        this.transformadores = transformadores;
    }


}
