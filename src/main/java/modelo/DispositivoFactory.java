package modelo;


public class DispositivoFactory {

public static DispositivoInteligente getAireAcondicionadoDe3500Frigroias() {
	DispositivoInteligente d = new DispositivoInteligente("Aire3500",false,1.613);
	d.restriccion.setCotasAireAcondicionado();
	return d;
}

public static DispositivoInteligente getAireAcondicionadoDe2200Frigroias() {
	DispositivoInteligente d = new DispositivoInteligente("Aire2200",true,1.013);
	d.restriccion.setCotasAireAcondicionado();
	return d;
}

public static DispositivoEstandar getTelevisorTuboFluor21() {
	DispositivoEstandar d = new DispositivoEstandar("TeveFluor21",false,0.075);
	d.restriccion.setCotasTelevisor();
	return d;
}

public static DispositivoEstandar getTelevisorTuboFluor29a34() {
	DispositivoEstandar d = new DispositivoEstandar("TeveFluor29a34",false,0.175);
	d.restriccion.setCotasTelevisor();
	return d;
}

public static DispositivoEstandar getLCD40() {
	DispositivoEstandar d = new DispositivoEstandar("LCD40",false,0.18);
	d.restriccion.setCotasTelevisor();
	return d;
}

public static DispositivoInteligente getLED24() {
	DispositivoInteligente d = new DispositivoInteligente("LED24",true,0.04);
	d.restriccion.setCotasTelevisor();
	return d;
}

public static DispositivoInteligente getLED32() {
	DispositivoInteligente d = new DispositivoInteligente("LED32",true,0.055);
	d.restriccion.setCotasTelevisor();
	return d;
}

public static DispositivoInteligente getLED40() {
	DispositivoInteligente d = new DispositivoInteligente("LED40",true,0.08);
	d.restriccion.setCotasTelevisor();
	return d;
}

public static DispositivoInteligente getHeladeraConFreezer() {
	return new DispositivoInteligente("HeladeraConFreezer",true,0.09);
}

public static DispositivoInteligente getHeladeraSinFreezer() {
	return new DispositivoInteligente("HeladeraSinFreezer",true,0.075);
}

public static DispositivoEstandar getLavarropaAuto5KConCalentamiento() {
	DispositivoEstandar d = new DispositivoEstandar("LavarropaAuto5KConCalentamiento",false,0.875);
	d.restriccion.setCotasLavarropa();
	return d;
}

public static DispositivoInteligente getLavarropaAuto5K() {
	DispositivoInteligente d = new DispositivoInteligente("LavarropaAuto5K",true,0.175);
	d.restriccion.setCotasLavarropa();
	return d;
}

public static DispositivoEstandar getLavarropaSemiAuto5K() {
	DispositivoEstandar d = new DispositivoEstandar("LavarropaSemiAuto5K",true,0.1275);
	d.restriccion.setCotasLavarropa();
	return d;
}

public static DispositivoEstandar getVentiladorDePie() {
	DispositivoEstandar d = new DispositivoEstandar("VentiladorDePie",true,0.09);
	d.restriccion.setCotasVentilador();
	return d;
}

public static DispositivoInteligente getVentiladorDeTecho() {
	DispositivoInteligente d = new DispositivoInteligente("VentiladorDeTecho",true,0.06);
	d.restriccion.setCotasVentilador();
	return d;
}

public static DispositivoInteligente getLamparaHalogena40W() {
	DispositivoInteligente d = new DispositivoInteligente("LamparaHalogena40W",false,0.04);
	d.restriccion.setCotasLampara();
	return d;
}

public static DispositivoInteligente getLamparaHalogena60W() {
	DispositivoInteligente d = new DispositivoInteligente("LamparaHalogena60W",false,0.06);
	d.restriccion.setCotasLampara();
	return d;
}

public static DispositivoInteligente getLamparaHalogena100W() {
	DispositivoInteligente d = new DispositivoInteligente("LamparaHalogena100W",false,0.015);
	d.restriccion.setCotasLampara();
	return d;
}

public static DispositivoInteligente getLampara11W() {
	DispositivoInteligente d = new DispositivoInteligente("Lampara11W",true,0.011);
	d.restriccion.setCotasLampara();
	return d;
}

public static DispositivoInteligente getLampara15W() {
	DispositivoInteligente d = new DispositivoInteligente("Lampara15W",true,0.015);
	d.restriccion.setCotasLampara();
	return d;
}

public static DispositivoInteligente getLampara20W() {
	DispositivoInteligente d = new DispositivoInteligente("Lampara20W",true,0.02);
	d.restriccion.setCotasLampara();
	return d;
}

public static DispositivoInteligente getPCEscritorio() {
	DispositivoInteligente d = new DispositivoInteligente("PCEscritorio",true,0.4);
	d.restriccion.setCotasComputadora();
	return d;
}

public static DispositivoEstandar getMicroondasConvencional() {
	DispositivoEstandar d = new DispositivoEstandar("MicroondasConvencional",true,0.64);
	d.restriccion.setCotasMicroondas();
	return d;
}

public static DispositivoEstandar getPlanchaAVapor() {
	DispositivoEstandar d = new DispositivoEstandar("PlanchaAVapor",true,0.75);
	d.restriccion.setCotasPlancha();
	return d;
}

}
