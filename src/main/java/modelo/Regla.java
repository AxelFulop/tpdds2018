package modelo;

import Servicios.Controller;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Regla extends Controller {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne(cascade = CascadeType.ALL) @JoinColumn(name = "regla_id")
    public Actuador actuador;

    public Regla(){

    }
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
