package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import common.TuplaDouble;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import modelo.factories.DispositivoFactory;
import repositorios.RepositorioClientes;

//CLASE PARA PROBAR SI PERSISTE RAPIDO
public class MainPrueba {

	public static void main(String[] args) {

        EntityManagerFactory d = Persistence.createEntityManagerFactory("db");
        EntityManager em = d.createEntityManager();

		EntityTransaction transaccion = em.getTransaction();
		
		Cliente cliente1 = new Cliente("Rodrigo", "Lopez", TipoIdentificacion.DNI, "123", 48262937, "Medrano 951", "JuanATR", "qwerty", 0);
	    Cliente cliente2 = new Cliente("Nicolas", "Merlis", TipoIdentificacion.DNI, "123", 48262937, "Medrano 951", "JuanATR", "qwerty", 0);
	    Cliente cliente3 = new Cliente("Axel", "Fulop", TipoIdentificacion.DNI, "123", 48262937, "Medrano 951", "JuanATR", "qwerty", 0);
	    Cliente cliente4 = new Cliente("Antonio", "Perez", TipoIdentificacion.DNI, "123", 48262937, "Medrano 951", "JuanATR", "qwerty", 0);
	    Cliente cliente5 = new Cliente("Nicolas", "Perez", TipoIdentificacion.DNI, "123", 48262937, "Medrano 951", "JuanATR", "qwerty", 0);
	    Cliente cliente6 = new Cliente("Mica", "Perez", TipoIdentificacion.DNI, "123", 48262937, "Medrano 951", "JuanATR", "qwerty", 0);


	    Transformador transformadorAlmagro = new Transformador();
	    Transformador transformadorCaballito = new Transformador();
	    Transformador transformadorColegiales = new Transformador();

	    List<Transformador> listaTransformadores1 = new ArrayList<Transformador>();
	    List<Transformador> listaTransformadores2 = new ArrayList<Transformador>();

	    ZonaGeografica zona1 = new ZonaGeografica();
	    ZonaGeografica zona2 = new ZonaGeografica();
	    
	    transformadorAlmagro.setUbicacion(new TuplaDouble(0D, 0D));
        transformadorAlmagro.setZonaGeografica(zona1);
        transformadorCaballito.setUbicacion(new TuplaDouble(5D, 5D));
        transformadorCaballito.setZonaGeografica(zona1);
        transformadorColegiales.setUbicacion(new TuplaDouble(15D, 15D));
        transformadorColegiales.setZonaGeografica(zona2);

        cliente1.setUbicacion(new TuplaDouble(0D, 1D));
        cliente2.setUbicacion(new TuplaDouble(1D, 0D));
        cliente3.setUbicacion(new TuplaDouble(1D, 0D));
        cliente4.setUbicacion(new TuplaDouble(6D, 5D));
        cliente5.setUbicacion(new TuplaDouble(5D, 6D));
        cliente6.setUbicacion(new TuplaDouble(16D, 15D));

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


        
		try {
			transaccion.begin();
			em.persist(zona1);
			em.persist(zona2);
			em.persist(transformadorAlmagro);
			em.persist(transformadorCaballito);
			em.persist(transformadorColegiales);
			em.persist(cliente1);
            em.persist(cliente2);
            em.persist(cliente3);
            em.persist(cliente4);
            em.persist(cliente5);
            em.persist(cliente6);
		
			transaccion.commit();
		}
		catch(Exception e) {
		    e.printStackTrace();
			transaccion.rollback();
		}
		
		em.close();

	}

}
