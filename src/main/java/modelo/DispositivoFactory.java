package modelo;


public class DispositivoFactory {

public static DispositivoInteligente getAireAcondicionadoDe3500Frigroias() {
	return new DispositivoInteligente("Aire3500",false,1.613);
}

public static DispositivoInteligente getAireAcondicionadoDe2200Frigroias() {
	return new DispositivoInteligente("Aire2200",true,1.013);
}

public static DispositivoEstandar getTelevisorTuboFluor21() {
	return new DispositivoEstandar("TeveFluor21",false,0.075);
}

public static DispositivoEstandar getTelevisorTuboFluor29a34() {
	return new DispositivoEstandar("TeveFluor29a34",false,0.175);
}

public static DispositivoEstandar getLCD40() {
	return new DispositivoEstandar("LCD40",false,0.18);
}

public static DispositivoInteligente getLED24() {
	return new DispositivoInteligente("LED24",true,0.04);
}

public static DispositivoInteligente getLED32() {
	return new DispositivoInteligente("LED32",true,0.055);
}

public static DispositivoInteligente getLED40() {
	return new DispositivoInteligente("LED40",true,0.08);
}

public static DispositivoInteligente getHeladeraConFreezer() {
	return new DispositivoInteligente("HeladeraConFreezer",true,0.09);
}

public static DispositivoInteligente getHeladeraSinFreezer() {
	return new DispositivoInteligente("HeladeraSinFreezer",true,0.075);
}

public static DispositivoEstandar getLavarropaAuto5KConCalentamiento() {
	return new DispositivoEstandar("LavarropaAuto5KConCalentamiento",false,0.875);
}

public static DispositivoInteligente getLavarropaAuto5K() {
	return new DispositivoInteligente("LavarropaAuto5K",true,0.175);
}

public static DispositivoEstandar getLavarropaSemiAuto5K() {
	return new DispositivoEstandar("LavarropaSemiAuto5K",true,0.1275);
}

public static DispositivoEstandar getVentiladorDePie() {
	return new DispositivoEstandar("VentiladorDePie",true,0.09);
}

public static DispositivoInteligente getVentiladorDeTecho() {
	return new DispositivoInteligente("VentiladorDeTecho",true,0.06);
}

public static DispositivoInteligente getLamparaHalogena40W() {
	return new DispositivoInteligente("LamparaHalogena40W",false,0.04);
}

public static DispositivoInteligente getLamparaHalogena60W() {
	return new DispositivoInteligente("LamparaHalogena60W",false,0.06);
}

public static DispositivoInteligente getLamparaHalogena100W() {
	return new DispositivoInteligente("LamparaHalogena100W",false,0.015);
}

public static DispositivoInteligente getLampara11W() {
	return new DispositivoInteligente("Lampara11W",true,0.011);
}

public static DispositivoInteligente getLampara15W() {
	return new DispositivoInteligente("Lampara15W",true,0.015);
}

public static DispositivoInteligente getLampara20W() {
	return new DispositivoInteligente("Lampara20W",true,0.02);
}

public static DispositivoInteligente getPCEscritorio() {
	return new DispositivoInteligente("PCEscritorio",true,0.4);
}

public static DispositivoEstandar getMicroondasConvencional() {
	return new DispositivoEstandar("MicroondasConvencional",true,0.64);
}

public static DispositivoEstandar getPlanchaAVapor() {
	return new DispositivoEstandar("PlanchaAVapor",true,0.75);
}

}
