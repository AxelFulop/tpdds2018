package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Regla {
    public Cliente cliente;
    public List<Actuador> actuadores;

    public Regla(Cliente c,List<Actuador> actuadores) {
        this.cliente = c;
        this.actuadores = actuadores;
    }
    public void llamarActuador(double medicion) {

    }


}
