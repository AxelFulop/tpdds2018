package modelo.sensores;

import modelo.Fabricante;

public class AdapterFabricante1 implements Fabricante {

	public float obtenerConsumoUltimasHoras(Integer h) {
		return (float) 15.5;
	}
}
