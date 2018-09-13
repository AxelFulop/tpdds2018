package reportes;

import java.time.LocalDate;
import modelo.Cliente;
import modelo.Dispositivo;
import modelo.Transformador;

public class GeneradorReportes {

	public static Double getReportePorHogar(Cliente cliente, LocalDate inicio, LocalDate fin) { // hogar = cliente
		int cantHoras = fin.compareTo(inicio)*24; //fin.compareTo(inicio) -> supongo que me da la cant de dias entre cada fecha
		Double consumo = 0d;   
        
        for(Dispositivo d:cliente.getDispositivos()) {
        	consumo += d.getConsumoMensual()*cantHoras / 720; // 720 hs tiene un mes
        }
        return consumo;
	}
	
	//no entendi muy bien este reporte a que se referia
	public static Double getReportePromedioPorDispositivo(Cliente c) {
		Double consumoTotal = 0d;
		for(Dispositivo d:c.getDispositivos()) {
			consumoTotal += d.getConsumoMensual();
		}
      
        return consumoTotal/c.cantidadDeDispositivos();
	}
	
	
	public static Double getReportePorTransformador(Transformador trans, LocalDate inicio, LocalDate fin) {
		Double consumo = 0d;
      
        for(Cliente c:trans.getClientes()) {
        	consumo += getReportePorHogar(c, inicio, fin);
        }
    
        return consumo;
	}
	
} 
