package modelo;

import Servicios.Model;
import Servicios.Session;
import common.Coordenada;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "transformador")
public class Transformador extends Model {
	@Id @GeneratedValue
	public Long id;
	//@OneToOne(cascade = CascadeType.ALL)
    //public ZonaGeografica zonaGeografica;
    @OneToMany(fetch = FetchType.LAZY) @JoinColumn(name = "transformador_id")
    public List<Cliente> clientes = new ArrayList<Cliente>();
    @Embedded
    public Coordenada ubicacion;

    public Transformador(){

    }
    public Double energiaQueEstaConsumiendo() {
        return clientes.stream().mapToDouble(c -> c.getConsumoInstantaneo()).sum();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public void addCliente(Cliente c) {
    	this.clientes.add(c);
    }

    public Coordenada getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Coordenada ubicacion) {
        this.ubicacion = ubicacion;
    }

    public static Transformador buscarPorId(int id)
    {
        return Session.getSession().find(Transformador.class,id);
    }
    public static List<Transformador> obtenerTodos() {
        return (List<Transformador>) Session.getSession().createQuery("SELECT e FROM Transformador e").getResultList();
    }
}


