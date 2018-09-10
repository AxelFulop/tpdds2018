package modelo.reglas;

import modelo.*;
import modelo.sensores.ActuadorOprtimizadorAhorroEnergia;

import java.util.List;

public class ReglaOptimizadorConsumoAlto extends Regla {

    public ReglaOptimizadorConsumoAlto(Actuador actuador) {
        super(actuador);
    }


    public void llamarActuador(DispositivoInteligente d,double consumoDeseado) {

                if (d.getConsumoMensual() >= consumoDeseado) {
                    actuador.ejecutarAccion(d);
                }


    }

}

