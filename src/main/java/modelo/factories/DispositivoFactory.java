package modelo.factories;

import modelo.DispositivoEstandar;
import modelo.DispositivoInteligente;
import modelo.Restriccion;

public class DispositivoFactory {

public static DispositivoInteligente getAireAcondicionadoDe3500Frigroias() {
	DispositivoInteligente d = new DispositivoInteligente("Aire3500",false,1.613);
	Restriccion restriccion = new Restriccion();
	restriccion.setCotasAireAcondicionado();
	d.setRestriccion(restriccion);
	return d;
}

public static DispositivoInteligente getAireAcondicionadoDe2200Frigroias() {
	DispositivoInteligente d = new DispositivoInteligente("Aire2200",true,1.013);
	Restriccion restriccion = new Restriccion();
	restriccion.setCotasAireAcondicionado();
	d.setRestriccion(restriccion);
	return d;
}

public static DispositivoEstandar getTelevisorTuboFluor21() {
	DispositivoEstandar d = new DispositivoEstandar("TeveFluor21",false,0.075);
	Restriccion restriccion = new Restriccion();
	restriccion.setCotasTelevisor();
	d.setRestriccion(restriccion);
	return d;
}

public static DispositivoEstandar getTelevisorTuboFluor29a34() {
	DispositivoEstandar d = new DispositivoEstandar("TeveFluor29a34",false,0.175);
	Restriccion restriccion = new Restriccion();
	restriccion.setCotasTelevisor();
	d.setRestriccion(restriccion);
	return d;
}

public static DispositivoEstandar getLCD40() {
	DispositivoEstandar d = new DispositivoEstandar("LCD40",false,0.18);
	Restriccion restriccion = new Restriccion();
	restriccion.setCotasTelevisor();
	d.setRestriccion(restriccion);
	return d;
}

public static DispositivoInteligente getLED24() {
	DispositivoInteligente d = new DispositivoInteligente("LED24",true,0.04);
	Restriccion restriccion = new Restriccion();
	restriccion.setCotasTelevisor();
	d.setRestriccion(restriccion);
	return d;
}

public static DispositivoInteligente getLED32() {
	DispositivoInteligente d = new DispositivoInteligente("LED32",true,0.055);
	d.restriccion.setCotasTelevisor();
	return d;
}

public static DispositivoInteligente getLED40() {
	DispositivoInteligente d = new DispositivoInteligente("LED40",true,0.08);
	Restriccion restriccion = new Restriccion();
	restriccion.setCotasTelevisor();
	d.setRestriccion(restriccion);
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
	Restriccion restriccion = new Restriccion();
	restriccion.setCotasLavarropa();
	d.setRestriccion(restriccion);
	return d;
}

public static DispositivoInteligente getLavarropaAuto5K() {
	DispositivoInteligente d = new DispositivoInteligente("LavarropaAuto5K",true,0.175);
	Restriccion restriccion = new Restriccion();
	restriccion.setCotasLavarropa();
	d.setRestriccion(restriccion);	return d;
}

public static DispositivoEstandar getLavarropaSemiAuto5K() {
	DispositivoEstandar d = new DispositivoEstandar("LavarropaSemiAuto5K",true,0.1275);
	Restriccion restriccion = new Restriccion();
	restriccion.setCotasLavarropa();
	d.setRestriccion(restriccion);	return d;
}

public static DispositivoEstandar getVentiladorDePie() {
	DispositivoEstandar d = new DispositivoEstandar("VentiladorDePie",true,0.09);
	Restriccion restriccion = new Restriccion();
	restriccion.setCotasVentilador();
	d.setRestriccion(restriccion);
	return d;
}

public static DispositivoInteligente getVentiladorDeTecho() {
	DispositivoInteligente d = new DispositivoInteligente("VentiladorDeTecho",true,0.06);
	Restriccion restriccion = new Restriccion();
	restriccion.setCotasVentilador();
	d.setRestriccion(restriccion);
	return d;
}

public static DispositivoInteligente getLamparaHalogena40W() {
	DispositivoInteligente d = new DispositivoInteligente("LamparaHalogena40W",false,0.04);
	Restriccion restriccion = new Restriccion();
	restriccion.setCotasLampara();
	d.setRestriccion(restriccion);	
	return d;
}

public static DispositivoInteligente getLamparaHalogena60W() {
	DispositivoInteligente d = new DispositivoInteligente("LamparaHalogena60W",false,0.06);
	Restriccion restriccion = new Restriccion();
	restriccion.setCotasLampara();
	d.setRestriccion(restriccion);	
	return d;
}

public static DispositivoInteligente getLamparaHalogena100W() {
	DispositivoInteligente d = new DispositivoInteligente("LamparaHalogena100W",false,0.015);
	Restriccion restriccion = new Restriccion();
	restriccion.setCotasLampara();
	d.setRestriccion(restriccion);	
	return d;
}

public static DispositivoInteligente getLampara11W() {
	DispositivoInteligente d = new DispositivoInteligente("Lampara11W",true,0.011);
	Restriccion restriccion = new Restriccion();
	restriccion.setCotasLampara();
	d.setRestriccion(restriccion);	
	return d;
}

public static DispositivoInteligente getLampara15W() {
	DispositivoInteligente d = new DispositivoInteligente("Lampara15W",true,0.015);
	Restriccion restriccion = new Restriccion();
	restriccion.setCotasLampara();
	d.setRestriccion(restriccion);	
	return d;
}

public static DispositivoInteligente getLampara20W() {
	DispositivoInteligente d = new DispositivoInteligente("Lampara20W",true,0.02);
	Restriccion restriccion = new Restriccion();
	restriccion.setCotasLampara();
	d.setRestriccion(restriccion);	
	return d;
}

public static DispositivoInteligente getPCEscritorio() {
	DispositivoInteligente d = new DispositivoInteligente("PCEscritorio",true,0.4);
	Restriccion restriccion = new Restriccion();
	restriccion.setCotasComputadora();
	d.setRestriccion(restriccion);	
	return d;
}

public static DispositivoEstandar getMicroondasConvencional() {
	DispositivoEstandar d = new DispositivoEstandar("MicroondasConvencional",true,0.64);
	Restriccion restriccion = new Restriccion();
	restriccion.setCotasMicroondas();
	d.setRestriccion(restriccion);	
	return d;
}

public static DispositivoEstandar getPlanchaAVapor() {
	DispositivoEstandar d = new DispositivoEstandar("PlanchaAVapor",true,0.75);
	Restriccion restriccion = new Restriccion();
	restriccion.setCotasPlancha();
	d.setRestriccion(restriccion);	
	return d;
}

}
