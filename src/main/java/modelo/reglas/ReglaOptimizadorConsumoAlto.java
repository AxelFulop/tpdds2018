package modelo.reglas;

import modelo.*;
import javax.persistence.Entity;

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

