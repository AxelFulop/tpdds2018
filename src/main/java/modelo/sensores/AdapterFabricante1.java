package modelo.sensores;

import modelo.Fabricante;

public class AdapterFabricante1 implements Fabricante {

	public float obtenerConsumoUltimasHoras(Integer horas) {
		return (float) 15.5;
	}
}
