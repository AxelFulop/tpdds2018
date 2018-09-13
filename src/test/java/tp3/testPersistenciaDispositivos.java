package tp3;


import common.TuplaDouble;
import modelo.*;
import org.junit.Before;
import org.junit.Test;

public class testPersistenciaDispositivos {

	@Before
	public void init(){

	}

	@Test
	public void creoDispositivoYloPersistoYLoElimino() {
		int cantidadDispositivos = Dispositivo.obtenerTodos().size();
		DispositivoEstandar tv = new DispositivoEstandar("tv", false,10);
		tv.persistir();
		DispositivoInteligente aire = new DispositivoInteligente("aire",true,1);
		aire.persistir();
		org.junit.Assert.assertEquals(cantidadDispositivos+2,Dispositivo.obtenerTodos().size());
		aire.eliminar();
		tv.eliminar();
		org.junit.Assert.assertEquals(cantidadDispositivos,Dispositivo.obtenerTodos().size());
	}

	@Test
	public void obtengoUltimoDipositivoYLoModifico() {
		int cantidadDispositivos = Dispositivo.obtenerTodos().size();
		Dispositivo dispositivo = Dispositivo.buscarPorId(cantidadDispositivos);
		Double kwhAnterior = dispositivo.kwh;
		dispositivo.setKwh(10D);
		dispositivo.actualizar();
		org.junit.Assert.assertNotEquals(kwhAnterior,Dispositivo.obtenerTodos().get(cantidadDispositivos-1));
	}

}
