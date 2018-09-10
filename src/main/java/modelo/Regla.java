package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Regla {
    public Actuador actuador;

    public Actuador getActuador() {
        return actuador;
    }

    public void setActuador(Actuador actuador) {
        this.actuador = actuador;
    }

    public Regla(Actuador actuador ) {
        this.actuador = actuador;
    }
    public void llamarActuador(DispositivoInteligente dispositivoAComparar,double medicion) {

    }


}
