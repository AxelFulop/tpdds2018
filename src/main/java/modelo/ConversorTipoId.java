package modelo;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ConversorTipoId implements AttributeConverter<TipoIdentificacion, String> {
	
	public TipoIdentificacion convertToEntityAttribute(String s) {
		if(s == "DNI") {
			return TipoIdentificacion.DNI;
		}
		else {
			if(s == "CI") {
				return TipoIdentificacion.CI;
			}
			else {
				if(s == "LE") {
					return TipoIdentificacion.LE;
				}
				else {
					return TipoIdentificacion.LC;
				}
			}
		}
	}
	
	public String convertToDatabaseColumn(TipoIdentificacion t) {
		if(t == TipoIdentificacion.DNI) {
			return "DNI";
		}
		else {
			if(t == TipoIdentificacion.CI) {
				return "CI";
			}
			else {
				if(t == TipoIdentificacion.LE) {
					return "LE";
				}
				else {
					return "LC";
				}
			}
		}
	}
	
}
