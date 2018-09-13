package modelo;

import common.Tuple;
import repositorios.RepositorioClientes;

import java.util.ArrayList;
import java.util.List;

public class Transformador {
    public ZonaGeografica zonaGeografica;
    public List<Cliente> clientes = new ArrayList<Cliente>();
    public Tuple<Double, Double> ubicacion = new Tuple<Double, Double>();

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
            if (obtenerDistancia(cliente.getUbicacion().getX(), ubicacion.getX(), cliente.getUbicacion().getY(), ubicacion.getY()) <= zonaGeografica.getRadioAbarcativo()) {
                clientes.add(cliente);
            }
        });
    }

    private double obtenerDistancia(Double x2, Double x1, Double y2, Double y1) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public Tuple<Double, Double> getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Tuple<Double, Double> ubicacion) {
        this.ubicacion = ubicacion;
    }
}


