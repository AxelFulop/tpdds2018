package modelo;

import Servicios.Model;
import common.Coordenada;
import repositorios.RepositorioClientes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "zonaGeografica")
public class ZonaGeografica extends Model {
	@Id @GeneratedValue
	public Long id;
    public String nombre;
    @OneToMany(fetch = FetchType.LAZY) @JoinColumn(name = "zonaGeografica_id")
    public List<Transformador> transformadores = new ArrayList<Transformador>();
    public Double radioAbarcativo = 10D;
    @Embedded
    public Coordenada ubicacion;

    public ZonaGeografica(){

    }

    public Double getConsumoTotal() {
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
    
    public void addTransformador(Transformador t) {
    	this.transformadores.add(t);
    }

    public Double getRadioAbarcativo() {
        return radioAbarcativo;
    }
    
    public void obtenerClientes() { // agrega los clientes que correspondan a todos los transformadores de la zona
        RepositorioClientes.getClientes().forEach(cliente -> {
        	for(Transformador trans:this.transformadores) {
        		if (obtenerDistancia(cliente.getUbicacion(), trans.getUbicacion()) <= this.radioAbarcativo) {
                    trans.addCliente(cliente);
                    break;					//un cliente pertenece a un unico transformador, por eso cuando encuentra     					
                }							//uno, sale del loop de transformadores y sigue al proximo cliente
        	}
        });
    }
    
    private Double obtenerDistancia(Coordenada t1, Coordenada t2) {
        return Math.sqrt(Math.pow(t1.getX() - t2.getX(), 2) + Math.pow(t1.getY() - t2.getY(), 2));
    }
}
