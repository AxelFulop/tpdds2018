package tp2;



import java.util.List;

import modelo.*;
import modelo.sensores.ActuadorEncenderAire;
import modelo.sensores.ReglaTemperaturaAlta;
import modelo.sensores.SensorTemperatura;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class testOptimizador {
Optimizador optimizador = new Optimizador();
Cliente cliente= new Cliente("Juan","Perez",TipoIdentificacion.DNI,123,48262937,"Medrano 951","JuanATR","qwerty",0);
DispositivoInteligente tv1 = DispositivoFactory.getLED40();
DispositivoInteligente aa1 = DispositivoFactory.getAireAcondicionadoDe2200Frigroias();
DispositivoInteligente pc1 = DispositivoFactory.getPCEscritorio();

Sensor sensorOptimizador = new SensorTemperatura();
Actuador prenderAire = new ActuadorEncenderAire();
Regla reglaApagadoOptimizacion = new ReglaTemperaturaAlta(tv1);
@Before
public void init(){
	cliente.agregarDispositivoInteligente(tv1);//00.8kwh
	cliente.agregarDispositivoInteligente(aa1);//1.013
	cliente.agregarDispositivoInteligente(pc1);//0.4
}

@SuppressWarnings("deprecation")
@Test
public void valoresNoNulosOptimizador() {
	List<Double> valoresOptimizados = optimizador.optimizar(cliente.getDispositivos(),200D);
	Assert.assertNotNull(valoresOptimizados);
}

@SuppressWarnings("deprecation")
@Test
public void valoresCorrectosOptimizador() {
	List<Double> valoresOptimizados = optimizador.optimizar(cliente.getDispositivos(),612D);
	Assert.assertTrue(((valoresOptimizados.get(0))*0.08D+(valoresOptimizados.get(1))*1.013D+(valoresOptimizados.get(2))*0.4D)<=612D); 
}
}
