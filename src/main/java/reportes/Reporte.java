package reportes;

import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Cliente;
import modelo.Dispositivo;
import modelo.DispositivoEstandar;
import modelo.DispositivoInteligente;
import modelo.Transformador;

public class Reporte {

	public static double getReportePorHogar(int id_cliente, LocalDate inicio, LocalDate fin) { // hogar = cliente
		int cantHoras = fin.compareTo(inicio)*24; //fin.compareTo(inicio) -> supongo que me da la cant de dias entre cada fecha
		double consumo = 0;
		EntityManagerFactory f = Persistence.createEntityManagerFactory("db");
        EntityManager em = f.createEntityManager();
        List<DispositivoEstandar> de = (List<DispositivoEstandar>) em.createQuery(
        		"from DispositivoEstandar de where de.cliente_id = :idc")
        		.setParameter("idc", id_cliente).getResultList();
        for(DispositivoEstandar d:de) {
        	consumo += d.getHorasDeUsoDiarias()*cantHoras;
        }
        
        List<DispositivoInteligente> di = (List<DispositivoInteligente>) em.createQuery(
        		"from DispositivoInteligente di where di.cliente_id = :idc")
        		.setParameter("idc", id_cliente).getResultList();
        for(DispositivoInteligente d:di) {
        	consumo += d.getConsumoMensual()*cantHoras / 720; // 720 hs tiene un mes
        }
        em.close();
        return consumo;    
	}
	
	//no entendi muy bien este reporte a que se referia
	public static double getReportePromedioPorDispositivo(DispositivoInteligente d, int id_cliente) {
		double consumo = 0;
		EntityManagerFactory f = Persistence.createEntityManagerFactory("db");
        EntityManager em = f.createEntityManager();
        Cliente cliente = (Cliente) em.createQuery(
        		"from Cliente cl where cl.id = :idc")
        		.setParameter("idt", id_cliente).getResultList().get(0);
        consumo = cliente.getDispositivos().stream().filter( disp => disp.getId() == d.getId() ).get(0).getConsumoMensual();
             
        em.close();
        return consumo;
	}
	
	public static double getReportePromedioPorDispositivo(DispositivoEstandar d, int id_cliente) {
		double consumo = 0;
		EntityManagerFactory f = Persistence.createEntityManagerFactory("db");
        EntityManager em = f.createEntityManager();
        Cliente cliente = (Cliente) em.createQuery(
        		"from Cliente cl where cl.id = :idc")
        		.setParameter("idt", id_cliente).getResultList().get(0);
        consumo = cliente.getDispositivos().stream().filter( disp => disp.getId() == d.getId() ).get(0).getConsumoMensual();
             
        em.close();
        return consumo;
	}
	
	public static double getReportePorTransformador(int id_cliente, LocalDate inicio, LocalDate fin) {
		double consumo = 0;
		EntityManagerFactory f = Persistence.createEntityManagerFactory("db");
        EntityManager em = f.createEntityManager();
        Transformador transformador = (Transformador) em.createQuery(
        		"from Transformador tr where tr.id = :id")
        		.setParameter("id",id_cliente).getResultList().get(0);
        for(Cliente c:transformador.getClientes()) {
        	consumo += getReportePorHogar(c.getId(), inicio, fin);
        }
        em.close();
        return consumo;
	}
	
}
