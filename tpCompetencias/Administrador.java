package tpCompetencias;

import java.time.LocalDate;

public class Administrador {

	private String domicilio, userName, password;
	private int nroIdentidad;
	private LocalDate fechaDeAltaSistema;

	
	public Administrador() {
		fechaDeAltaSistema = LocalDate.now();
		}
	
	
	public int cuantoTiempoSiendoAdm() {
		return this.getTiempoDeAdm();
	}
}
