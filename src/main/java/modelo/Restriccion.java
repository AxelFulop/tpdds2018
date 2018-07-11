package modelo;

public class Restriccion {
public double cotaSuperior;
public double cotaInferior;

public Restriccion(double cotaSuperior, double cotaInferior) {
	this.cotaInferior = cotaInferior;
	this.cotaSuperior = cotaSuperior;
}

public double getCotaSuperior() {
	return cotaSuperior;
}

public void setCotaSuperior(double cotaSuperior) {
	this.cotaSuperior = cotaSuperior;
}

public double getCotaInferior() {
	return cotaInferior;
}

public void setCotaInferior(double cotaInferior) {
	this.cotaInferior = cotaInferior;
}
	
}
