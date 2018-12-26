package jobs;

import modelo.*;
import modelo.Actuadores.ActuadorOprtimizadorAhorroEnergia;
import modelo.factories.DispositivoFactory;
import modelo.reglas.ReglaOptimizadorConsumoAlto;
import modelo.sensores.SensorOptimizador;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.ArrayList;
import java.util.List;

public class SensorJob implements Job {

    static List<DispositivoInteligente> dispositivosInteligentes;
    static Sensor sensorOptimizador = new SensorOptimizador();
    static Actuador actuadorOptimizador ;
    static Regla reglaApagadoOptimizacion;


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        dispositivosInteligentes = DispositivoInteligente.obtenerInteligentes();
        actuadorOptimizador = new ActuadorOprtimizadorAhorroEnergia(dispositivosInteligentes);
        reglaApagadoOptimizacion = new ReglaOptimizadorConsumoAlto(actuadorOptimizador, "unNombre");
        sensorOptimizador.addRegla(reglaApagadoOptimizacion);
        sensorOptimizador.tomarMedicion();
    }
}
