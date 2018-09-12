package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "zonaGeografica")
public class ZonaGeografica {
	@Id @GeneratedValue
	public int id;
    public String nombre;
    @OneToMany(fetch = FetchType.LAZY) @JoinColumn(name = "zonaGeografica_id")
    public List<Transformador> transformadores = new ArrayList<Transformador>();
    public Double radioAbarcativo = 10D;


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

    public Double getRadioAbarcativo() {
        return radioAbarcativo;
    }
}
