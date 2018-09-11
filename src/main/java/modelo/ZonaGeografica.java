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
@Table(name = "zona")
public class ZonaGeografica {
	@Id @GeneratedValue
	@Column (name = "zona_id")
	private int id;
    private String nombre;
    @OneToMany(fetch = FetchType.LAZY) @JoinColumn(name = "zona_id")
    private List<Transformador> transformadores = new ArrayList<Transformador>();
    private Double radioAbarcativo = 10D;


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
