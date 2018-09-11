package modelo;

import javax.persistence.Embeddable;

@Embeddable
public enum TipoIdentificacion {
	DNI,
	CI,
	LE,
	LC
}
