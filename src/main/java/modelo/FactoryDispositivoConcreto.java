package modelo;



public class FactoryDispositivoConcreto {

public static DispositivoInteligente getAireAcondicionadoDe3500Frigroias() {
	DispositivoInteligente d = new DispositivoInteligente("Aire3500");
	d.setBajoConsumo(true);
	d.setKwh(1.613);
	return d;
}

// TODO: restoDeDispositivos
	
}
