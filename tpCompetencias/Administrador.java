package tpCompetencias;

import java.time.LocalDate;

public class Administrador {

	private String domicilio, userName, password;
	private int nroIdentidad, tiempoDeAdm;
	private LocalDate fechaDeAltaSistema;

	public int getTiempoDeAdm() {
		return tiempoDeAdm;
	}

	public int cuantoTiempoSiendoAdm() {
		return this.getTiempoDeAdm();
	}
}
