package tp3;


import modelo.*;
import org.junit.Test;

public class testPersistenciaDispositivos {


	@Test
	public void creoDispositivoYloPersistoYLoElimino() {
		int cantidadDispositivos = Dispositivo.obtenerTodos().size();
		DispositivoEstandar tv = new DispositivoEstandar("tv", false,10d);
		tv.persistir();
		DispositivoInteligente aire = new DispositivoInteligente("aire",true,1d);
		aire.persistir();
		org.junit.Assert.assertEquals(cantidadDispositivos+2,Dispositivo.obtenerTodos().size());
		aire.eliminar();
		tv.eliminar();
		org.junit.Assert.assertEquals(cantidadDispositivos,Dispositivo.obtenerTodos().size());
	}

	@Test
	public void obtengoUltimoDipositivoYLoModifico() {
		DispositivoInteligente aire = new DispositivoInteligente("aire",true,1d);
		aire.persistir();
		int cantidadDispositivos = Dispositivo.obtenerTodos().size();
		Dispositivo dispositivo = Dispositivo.obtenerTodos().get(cantidadDispositivos-1);
		Double kwhAnterior = dispositivo.kwh;
		dispositivo.setKwh(10D);
		dispositivo.actualizar();
		org.junit.Assert.assertNotEquals(kwhAnterior,Dispositivo.obtenerTodos().get(cantidadDispositivos-1));
		dispositivo.eliminar();
	}

}
