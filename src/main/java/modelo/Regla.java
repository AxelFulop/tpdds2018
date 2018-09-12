package modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public abstract class Regla {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne @JoinColumn(name = "regla_id")
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
