package modelo.reglas;

import modelo.*;
import modelo.sensores.ActuadorOprtimizadorAhorroEnergia;

import java.util.List;

public class ReglaOptimizadorConsumoAlto extends Regla {

    public ReglaOptimizadorConsumoAlto(List<Actuador> actuadores) {
        super(actuadores);
    }


    public void llamarActuador(Dispositivo d,double consumoDeseado) {


        actuadores.stream().forEach(ac -> {
                if (d.getConsumoMensual() >= consumoDeseado) {
                    ac.ejecutarAccion(d);
                }
        });

        /* if (dispositivo.getConsumoMensual() >= consumoDeseado) {
                    ac.ejecutarAccion();
                }*/

    }

}

