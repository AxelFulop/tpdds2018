package tp2;



import java.util.ArrayList;
import java.util.List;

import modelo.*;
import modelo.Actuadores.ActuadorOprtimizadorAhorroEnergia;
import modelo.factories.DispositivoFactory;
import modelo.reglas.ReglaOptimizadorConsumoAlto;
import modelo.sensores.*;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class testOptimizador {
	Optimizador optimizador = new Optimizador();

	Cliente cliente= new Cliente("Juan","Perez",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","JuanATR","qwerty",0);

	List<DispositivoInteligente> dispositivosInteligentes = new ArrayList<DispositivoInteligente>();

	DispositivoInteligente tv1 = DispositivoFactory.getLED40();
	DispositivoInteligente aa1 = DispositivoFactory.getAireAcondicionadoDe3500Frigroias();
	DispositivoInteligente pc1 = DispositivoFactory.getPCEscritorio();

	Sensor sensorOptimizador = new SensorOptimizador();
	Actuador actuadorOptimizador ;
	Regla reglaApagadoOptimizacion;

	@Before
	public void init(){
		aa1.setConsumoMensual(500D);
		cliente.agregarDispositivoInteligente(aa1);//1.013
		tv1.setConsumoMensual(110D);
		cliente.agregarDispositivoInteligente(tv1);//00.8kwh
		pc1.setConsumoMensual(50D);
		cliente.agregarDispositivoInteligente(pc1);//0.4

		dispositivosInteligentes.add(aa1);
		dispositivosInteligentes.add(tv1);
		dispositivosInteligentes.add(pc1);

		actuadorOptimizador = new ActuadorOprtimizadorAhorroEnergia(dispositivosInteligentes);

		reglaApagadoOptimizacion = new ReglaOptimizadorConsumoAlto(actuadorOptimizador, "unNombre");

		cliente.addSensor(sensorOptimizador);
	}

	@Test
	public void valoresNoNulosOptimizador() {
		List<Double> valoresOptimizados = optimizador.optimizar(cliente.getDispositivos(),200D);
		Assert.assertNotNull(valoresOptimizados);
	}

	@Test
	public void valoresCorrectosOptimizador() {
		List<Double> valoresOptimizados = optimizador.optimizar(cliente.getDispositivos(),612D);
		Assert.assertTrue(((valoresOptimizados.get(0))*0.08D+(valoresOptimizados.get(1))*1.013D+(valoresOptimizados.get(2))*0.4D)<=612D);
	}

	@Test
	public void seteaDispositivosEnAhorroDeEnergiaSiEsQueSuperaLimiteDeConsumo() {
		cliente.getDispositivosInteligentes().get(0).setEstado(Estado.ENCENDIDO);
		Assert.assertEquals(aa1.getEstado(),Estado.ENCENDIDO);
		cliente.getDispositivosInteligentes().get(1).setEstado(Estado.ENCENDIDO);
		Assert.assertEquals(tv1.getEstado(),Estado.ENCENDIDO);
		cliente.getDispositivosInteligentes().get(2).setEstado(Estado.ENCENDIDO);
		Assert.assertEquals(pc1.getEstado(),Estado.ENCENDIDO);

		sensorOptimizador.addRegla(reglaApagadoOptimizacion);
		cliente.getSensores().forEach(sensor -> sensor.tomarMedicion()); //sensorOptimizador.tomarMedicion();
		Assert.assertEquals(Estado.AHORROENERGIA,cliente.getDispositivosInteligentes().get(0).getEstado()); //Dado los dispositivos que se cargaron en el usuario para este test, el aire es el unico dispositivo
		//que supera el valor maximo de uso para este luego de resolver el Optimizador
		Assert.assertEquals(Estado.ENCENDIDO,cliente.getDispositivosInteligentes().get(1).getEstado());
		Assert.assertEquals(Estado.ENCENDIDO,cliente.getDispositivosInteligentes().get(2).getEstado());

	}
}
