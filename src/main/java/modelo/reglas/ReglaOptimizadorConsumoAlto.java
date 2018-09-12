package modelo.reglas;

import modelo.*;
//import org.uqbar.commons.utils.Observable;

import javax.persistence.Entity;

//@Observable
@Entity
public class ReglaOptimizadorConsumoAlto extends Regla {

    public ReglaOptimizadorConsumoAlto(){

    }
    public ReglaOptimizadorConsumoAlto(Actuador actuador) {
        super(actuador);
    }


    public void llamarActuador(DispositivoInteligente d,double consumoDeseado) {

                if (d.getConsumoMensual() >= consumoDeseado) {
                    actuador.ejecutarAccion(d);
                }


    }

}

