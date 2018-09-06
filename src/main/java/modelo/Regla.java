package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Regla {
    public Cliente cliente;

    public List<DispositivoInteligente> dispositivos = new ArrayList<DispositivoInteligente>();

    public Regla(Cliente c, List<DispositivoInteligente> d) {
        this.dispositivos = d;
        this.cliente = c;
    }

    public void ejecutar(double medicion) {

    }


}
