package modelo.reglas;

import modelo.Actuador;
import modelo.Cliente;
import modelo.DispositivoInteligente;
import modelo.Regla;
import modelo.sensores.ActuadorOprtimizadorAhorroEnergia;

import java.util.List;

public class ReglaOptimizadorConsumoAlto extends Regla {

    public ReglaOptimizadorConsumoAlto(Cliente c, List<Actuador> actuadores) {
        super(c, actuadores);
    }

    @Override
    public void llamarActuador(double consumoDeseado) {


        actuadores.stream().forEach(ac -> {
            ac.dispositivos.stream().forEach(dis -> {
                if (dis.getConsumoMensual() >= consumoDeseado) {
                    ac.ejecutarAccion();
                }
            });
        });


    }

}

