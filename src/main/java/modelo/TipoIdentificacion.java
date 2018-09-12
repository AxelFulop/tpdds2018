package modelo;

import javax.persistence.Embeddable;
import javax.persistence.Enumerated;

@Embeddable
public enum TipoIdentificacion {
	DNI,
	CI,
	LE,
	LC
}
