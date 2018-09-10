package tp2;

import java.util.ArrayList;
import java.util.List;

import modelo.common.Tuple;
import modelo.repositorios.RepositorioClientes;
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


    Cliente cliente1 = new Cliente("Rodrigo", "Lopez", TipoIdentificacion.DNI, 123, 48262937, "Medrano 951", "JuanATR", "qwerty", 0);
    Cliente cliente2 = new Cliente("Nicolas", "Merlis", TipoIdentificacion.DNI, 123, 48262937, "Medrano 951", "JuanATR", "qwerty", 0);
    Cliente cliente3 = new Cliente("Axel", "Fulop", TipoIdentificacion.DNI, 123, 48262937, "Medrano 951", "JuanATR", "qwerty", 0);
    Cliente cliente4 = new Cliente("Antonio", "Perez", TipoIdentificacion.DNI, 123, 48262937, "Medrano 951", "JuanATR", "qwerty", 0);
    Cliente cliente5 = new Cliente("Nicolas", "Perez", TipoIdentificacion.DNI, 123, 48262937, "Medrano 951", "JuanATR", "qwerty", 0);
    Cliente cliente6 = new Cliente("Mica", "Perez", TipoIdentificacion.DNI, 123, 48262937, "Medrano 951", "JuanATR", "qwerty", 0);

    List<Cliente> listaClientes1 = new ArrayList<Cliente>();
    List<Cliente> listaClientes2 = new ArrayList<Cliente>();
    List<Cliente> listaClientes3 = new ArrayList<Cliente>();


    Transformador transformadorAlmagro = new Transformador();
    Transformador transformadorCaballito = new Transformador();
    Transformador transformadorColegiales = new Transformador();

    List<Transformador> listaTransformadores1 = new ArrayList<Transformador>();
    List<Transformador> listaTransformadores2 = new ArrayList<Transformador>();

    ZonaGeografica zona1 = new ZonaGeografica();
    ZonaGeografica zona2 = new ZonaGeografica();

    @Before
    public void init() {

        transformadorAlmagro.setUbicacion(new Tuple<Double, Double>(0D, 0D));
        transformadorAlmagro.setZonaGeografica(zona1);
        transformadorCaballito.setUbicacion(new Tuple<Double, Double>(5D, 5D));
        transformadorCaballito.setZonaGeografica(zona1);
        transformadorColegiales.setUbicacion(new Tuple<Double, Double>(15D, 15D));
        transformadorColegiales.setZonaGeografica(zona2);

        cliente1.setUbicacion(new Tuple<Double, Double>(0D, 1D));
        cliente2.setUbicacion(new Tuple<Double, Double>(1D, 0D));
        cliente3.setUbicacion(new Tuple<Double, Double>(1D, 0D));
        cliente4.setUbicacion(new Tuple<Double, Double>(6D, 5D));
        cliente5.setUbicacion(new Tuple<Double, Double>(5D, 6D));
        cliente6.setUbicacion(new Tuple<Double, Double>(16D, 15D));


        List<Cliente> listaClientes1 = new ArrayList<Cliente>();
        List<Cliente> listaClientes2 = new ArrayList<Cliente>();
        List<Cliente> listaClientes3 = new ArrayList<Cliente>();

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

        RepositorioClientes.addCliente(cliente1);
        RepositorioClientes.addCliente(cliente2);
        RepositorioClientes.addCliente(cliente3);
        RepositorioClientes.addCliente(cliente4);
        RepositorioClientes.addCliente(cliente5);
        RepositorioClientes.addCliente(cliente6);




        listaTransformadores1.add(transformadorColegiales);
        listaTransformadores1.add(transformadorAlmagro);
        listaTransformadores2.add(transformadorCaballito);

        zona1.setTransformadores(listaTransformadores1);
        zona2.setTransformadores(listaTransformadores2);

        transformadorAlmagro.obtenerClientes();
        transformadorCaballito.obtenerClientes();
        transformadorColegiales.obtenerClientes();
    }

    @Test
    public void obtenerConsumoInstantaneo() {

        double consumoZona1 = zona1.getConsumoTotal();
        double consumoZona2 = zona2.getConsumoTotal();
        Assert.assertEquals(consumoZona1, 12.0);
        Assert.assertEquals(consumoZona2, 10.0);
    }

    @Test
    public void suministroEnergiaInstantaneaEnUnTransformador() {
        double consumoTransformador = transformadorAlmagro.energiaQueEstaConsumiendo();
        Assert.assertEquals(consumoTransformador, 4.0);
    }

}
