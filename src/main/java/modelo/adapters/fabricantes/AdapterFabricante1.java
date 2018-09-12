package modelo.adapters.fabricantes;

import modelo.Fabricante;
//import org.uqbar.commons.utils.Observable;

import javax.persistence.Entity;

//@Observable
@Entity
public class AdapterFabricante1 extends Fabricante {

	@Override
	public float obtenerConsumoUltimasHoras(Integer h) {
		return (float) 15.5;
	}
}
