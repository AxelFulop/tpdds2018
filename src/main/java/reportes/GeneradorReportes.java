package reportes;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import Servicios.UsuarioService;
import modelo.Cliente;
import modelo.Dispositivo;
import modelo.DispositivoInteligente;
import modelo.Transformador;

public class GeneradorReportes {
	public static float diferenciaEnHoras(LocalDate inicio, LocalDate fin) {
		ZoneId defaultZoneId = ZoneId.systemDefault();		
		Date dateInicio = Date.from(inicio.atStartOfDay(defaultZoneId).toInstant());
		Date dateFin = Date.from(fin.atStartOfDay(defaultZoneId).toInstant());
		
		long diff = dateFin.getTime() - dateInicio.getTime();
		float days = (diff / (1000*60*60*24));
	    return days*24;
	}

	public static Double getReportePorHogar(Cliente cliente, LocalDate inicio, LocalDate fin) { // hogar = cliente
		try {
			float cantHoras = GeneradorReportes.diferenciaEnHoras(inicio, fin);
			Double consumo = 0d;
			for (Dispositivo d : cliente.getDispositivos()) {
				consumo += d.getConsumoMensual() * cantHoras / 720; // 720 hs tiene un mes
			}
			return consumo;
		}catch (Exception e)
		{
			return 0d;
		}
	}
	/*
	public static Double getReportePorDispositivo(Cliente c) {
		Double consumoTotal = 0d;
		for(Dispositivo d:c.getDispositivos()) {
			consumoTotal += d.getConsumoMensual();
		}
      
        return consumoTotal/c.cantidadDeDispositivos();
	} */
	
	public static HashMap<Dispositivo,Double> getReportePorDispositivo(Cliente c) {
		HashMap<Dispositivo,Double> mapa = new HashMap<Dispositivo,Double>();
		for(Dispositivo d:c.getDispositivos()) {
			mapa.put(d, d.getConsumoMensual());
		}
      
        return mapa;
	}
	
	
	public static Double getReportePorTransformador(Transformador trans, LocalDate inicio, LocalDate fin) {
		Double consumo = 0d;
      
        for(Cliente c:trans.getClientes()) {
        	consumo += getReportePorHogar(c, inicio, fin);
        }
    
        return consumo;
	}
	
} 
