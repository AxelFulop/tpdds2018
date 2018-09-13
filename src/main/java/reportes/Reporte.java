package reportes;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Cliente;
import modelo.Dispositivo;

public class Reporte {

	public static double getReportePorHogar(LocalDate inicio, LocalDate fin) {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("db");
        EntityManager em = f.createEntityManager();
	}
	
	public static double getReportePromedioPorDispositivo(Dispositivo d, Cliente c) {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("db");
        EntityManager em = f.createEntityManager();
        return 3;
	}
	
	public static double getReportePorTransformador(LocalDate inicio, LocalDate fin) {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("db");
        EntityManager em = f.createEntityManager();
	}
}
