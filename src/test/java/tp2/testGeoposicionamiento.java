package tp2;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import modelo.Cliente;
import modelo.DispositivoInteligente;
import modelo.TipoIdentificacion;
import modelo.Transformador;
import modelo.ZonaGeografica;
import modelo.factories.DispositivoFactory;

public class testGeoposicionamiento {


Cliente cliente1= new Cliente("Rodrigo","Lopez",TipoIdentificacion.DNI,123,48262937,"Medrano 951","JuanATR","qwerty",0);
Cliente cliente2= new Cliente("Nicolas","Merlis",TipoIdentificacion.DNI,123,48262937,"Medrano 951","JuanATR","qwerty",0);
Cliente cliente3= new Cliente("Axel","Fulop",TipoIdentificacion.DNI,123,48262937,"Medrano 951","JuanATR","qwerty",0);
Cliente cliente4= new Cliente("Antonio","Perez",TipoIdentificacion.DNI,123,48262937,"Medrano 951","JuanATR","qwerty",0);
Cliente cliente5= new Cliente("Nicolas","Perez",TipoIdentificacion.DNI,123,48262937,"Medrano 951","JuanATR","qwerty",0);
Cliente cliente6= new Cliente("Mica","Perez",TipoIdentificacion.DNI,123,48262937,"Medrano 951","JuanATR","qwerty",0);

List<Cliente> listaClientes1;
List<Cliente> listaClientes2;
List<Cliente> listaClientes3;
	
Transformador transformadorAlmagro = new Transformador();
Transformador transformadorCaballito = new Transformador();
Transformador transformadorColegiales = new Transformador();

List<Transformador> listaTransformadores1;
List<Transformador> listaTransformadores2;

ZonaGeografica zona1 = new ZonaGeografica();
ZonaGeografica zona2 = new ZonaGeografica();

@Before
public void init() {
	
	DispositivoInteligente tv1 = DispositivoFactory.getLED40();
	DispositivoInteligente aa1 = DispositivoFactory.getAireAcondicionadoDe3500Frigroias();
	
	cliente1.agregarDispositivoInteligente(tv1);//00.8kwh
	cliente1.agregarDispositivoInteligente(aa1);//1.013
	cliente2.agregarDispositivoInteligente(tv1);//00.8kwh
	cliente2.agregarDispositivoInteligente(aa1);//1.013
	cliente3.agregarDispositivoInteligente(tv1);//00.8kwh
	cliente3.agregarDispositivoInteligente(aa1);//1.013
	cliente4.agregarDispositivoInteligente(tv1);//00.8kwh
	cliente4.agregarDispositivoInteligente(aa1);//1.013
	cliente5.agregarDispositivoInteligente(tv1);//00.8kwh
	cliente5.agregarDispositivoInteligente(aa1);//1.013
	cliente6.agregarDispositivoInteligente(tv1);//00.8kwh
	cliente6.agregarDispositivoInteligente(aa1);//1.013
	
	listaClientes1.add(cliente1);
	listaClientes1.add(cliente2);
	
	listaClientes2.add(cliente3);
	listaClientes2.add(cliente4);
	
	listaClientes3.add(cliente5);
	listaClientes3.add(cliente6);
	
	transformadorAlmagro.setClientes(listaClientes1);
	transformadorCaballito.setClientes(listaClientes2);
	transformadorColegiales.setClientes(listaClientes3);
	
	listaTransformadores1.add(transformadorColegiales);
	listaTransformadores1.add(transformadorAlmagro);
	listaTransformadores2.add(transformadorCaballito);
	
	zona1.setTransformadores(listaTransformadores1);
	zona2.setTransformadores(listaTransformadores2);
		
}

@Test
public void obtenerConsumoInstantaneo() {
	double consumoZona1 = zona1.getConsumoTotal();
	double consumoZona2 = zona2.getConsumoTotal();
	Assert.assertEquals(consumoZona1, 4);
	Assert.assertEquals(consumoZona1, 2);
}
	
}
