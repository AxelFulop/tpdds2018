package tpCompetencias;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Cliente {

	private String nombre, apellido, tipoDoc, domicilio;
	private String userName, password;
	private int numeroDoc, telefono;
	private LocalDate fechaDeAltaServico;
	private List<Dispositivo> dispositivos;
	private Categoria categoria;

	public void pasaDeCategoria(Categoria unaCategoria) {
		categoria = unaCategoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	private  void  adquirirUnDispositivo(Dispositivo unDispositivo) {
		dispositivos.add(unDispositivo);
	}
	
	
	
	public boolean algunDispositivoEstaEncendido() {
		return this.dispositivos.stream().anyMatch(
				dispo -> dispo.estaEncendido());
	}

	public boolean algunDispositivoEstaApagado() {

		return !this.algunDispositivoEstaEncendido();

	}

	public int cantDeApagados() {
		return this.dispositivos.stream()
				.filter(dispo -> dispo.noEstaEncendido())
				.collect(Collectors.toList()).size();
	}

	public int cantDeEncendidos() {
		return this.dispositivos.stream()
				.filter(dispo -> dispo.estaEncendido())
				.collect(Collectors.toList()).size();
	}

	public int cantDeDispositivos() {
		return this.dispositivos.size();
	}

	public void utilizaTusDispositivosGastantando(float  kwh)
	{
	 this.dispositivos.stream().forEach(dispo -> dispo.consumiEnergia(kwh));	
	}

}

