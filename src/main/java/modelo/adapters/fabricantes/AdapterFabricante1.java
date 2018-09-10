package modelo.adapters.fabricantes;

import modelo.Fabricante;

public class AdapterFabricante1 extends Fabricante {

	@Override
	public float obtenerConsumoUltimasHoras(Integer h) {
		return (float) 15.5;
	}
}
