package tp3;


import modelo.*;
import modelo.Actuadores.ActuadorEncenderAire;
import modelo.factories.DispositivoFactory;
import modelo.reglas.ReglaTemperaturaAlta;
import modelo.sensores.SensorTemperatura;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class testPersistenciaReglasActuadoresYSensores {


		DispositivoInteligente aire = DispositivoFactory.getAireAcondicionadoDe3500Frigroias();
		Sensor sensorTemp = new SensorTemperatura();
		Actuador actuadorPrenderAire;
		Regla reglaTemperaturaAlta;

		@Before
		public void init(){
			aire.apagar();

			List<DispositivoInteligente> dispositivos = new ArrayList<DispositivoInteligente>();
			dispositivos.add(aire);

			actuadorPrenderAire = new ActuadorEncenderAire(dispositivos);
			reglaTemperaturaAlta =  new ReglaTemperaturaAlta(actuadorPrenderAire, "unNombre");
			sensorTemp.addRegla(reglaTemperaturaAlta);


		}
	@Test
	public void buscoSiSePersitioElSensorYEjecuto() {
		Assert.assertEquals(aire.getEstado(),Estado.APAGADO);
		aire.persistir();
		int cantidadDeSensores = Sensor.obtenerTodos().size();
		sensorTemp.persistir();
		Assert.assertEquals(cantidadDeSensores+1,Sensor.obtenerTodos().size());
		Sensor sensorRecuperado = Sensor.obtenerTodos().get(cantidadDeSensores);
		sensorRecuperado.EjecutarReglasAsociadas();
		Assert.assertEquals(aire.getEstado(),Estado.ENCENDIDO);
		sensorTemp.eliminar();
		aire.eliminar();
	}
	@Test
	public void buscoActuadorYleAgregoUnNuevoDispositivoParaEncender() {
		aire.persistir();
		int cantidadDeSensores = Sensor.obtenerTodos().size();
		sensorTemp.persistir();
		Assert.assertEquals(cantidadDeSensores+1,Sensor.obtenerTodos().size());
		Sensor sensorRecuperado = Sensor.obtenerTodos().get(cantidadDeSensores);
		DispositivoInteligente nuevoDispositivo = DispositivoFactory.getPCEscritorio();
		nuevoDispositivo.setEstado(Estado.APAGADO);
		nuevoDispositivo.persistir();
		sensorRecuperado.getReglas().forEach(regla -> {
			regla.getActuador().agregarDispositivo(nuevoDispositivo);
		});
		sensorTemp.actualizar();
		Sensor.obtenerTodos().get(cantidadDeSensores).EjecutarReglasAsociadas();
		Assert.assertEquals(aire.getEstado(),Estado.ENCENDIDO);
		Assert.assertEquals(nuevoDispositivo.getEstado(),Estado.ENCENDIDO);

		sensorTemp.eliminar();
		aire.eliminar();
		nuevoDispositivo.eliminar();
	}

	
}
