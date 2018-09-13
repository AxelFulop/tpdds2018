package modelo;

import Servicios.Controller;
import Servicios.Session;
import common.TuplaDouble;
import repositorios.RepositorioClientes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "transformador")
public class Transformador extends Controller {
	@Id @GeneratedValue
	public int id;
	@OneToOne(cascade = CascadeType.ALL)
    public ZonaGeografica zonaGeografica;
    @OneToMany(fetch = FetchType.LAZY) @JoinColumn(name = "transformador_id")
    public List<Cliente> clientes = new ArrayList<Cliente>();
    @Embedded
    public TuplaDouble ubicacion;

    public Transformador(){

    }
    public double energiaQueEstaConsumiendo() {
        return clientes.stream().mapToDouble(c -> c.getConsumoInstantaneo()).sum();
    }

    public ZonaGeografica getZonaGeografica() {
        return zonaGeografica;
    }

    public void setZonaGeografica(ZonaGeografica zonaGeografica) {
        this.zonaGeografica = zonaGeografica;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void obtenerClientes() {

        RepositorioClientes.getClientes().forEach(cliente -> {
            if (obtenerDistancia(cliente.getUbicacion(), this.ubicacion) <= zonaGeografica.getRadioAbarcativo()) {
                clientes.add(cliente);
            }
        });//TODO: MAndar a la zona, y esta decide a quien le manda los clientes.
    }

    private double obtenerDistancia(TuplaDouble t1, TuplaDouble t2) {
        return Math.sqrt(Math.pow(t1.getX() - t2.getX(), 2) + Math.pow(t1.getY() - t2.getY(), 2));
    }

    public TuplaDouble getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(TuplaDouble ubicacion) {
        this.ubicacion = ubicacion;
    }

    public static Transformador buscarPorId(int id)
    {
        return Session.getSession().find(Transformador.class,id);
    }
    public static List<Transformador> obtenerTodos() {
        return Session.getSession().createQuery("SELECT e FROM Transformador e").getResultList();
    }
}


