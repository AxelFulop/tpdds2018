package jobs;

import modelo.*;
import modelo.Actuadores.ActuadorOprtimizadorAhorroEnergia;
import modelo.factories.DispositivoFactory;
import modelo.reglas.ReglaOptimizadorConsumoAlto;
import modelo.sensores.SensorOptimizador;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class SensorJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<Sensor> sensores = Sensor.obtenerTodos();
        if (sensores!=null)
        {
            sensores.forEach(s->{
                s.tomarMedicion();
                System.out.print("Medicion tomada con exito (--Job :P--)");

            });
        }
    }
}
