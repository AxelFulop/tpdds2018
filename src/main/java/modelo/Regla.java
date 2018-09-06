package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Regla {
    public List<Actuador> actuadores;

    public Regla(List<Actuador> actuadores) {
        this.actuadores = actuadores;
    }
    public void llamarActuador(Dispositivo dispositivoAComparar,double medicion) {

    }


}
