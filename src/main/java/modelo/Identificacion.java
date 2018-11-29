package modelo;

import javax.persistence.*;

@Embeddable
public class Identificacion {
	@Enumerated(EnumType.STRING)// @Convert(converter = ConversorTipoId.class): Para el que hizo esto, son la anottation Enumerated, hace lo mismo y definis el ttipo de dato que queres que persista en la BD
	@Column(name = "tipoIdentificacion")
	public TipoIdentificacion tipo;
	@Column(name = "numeroIdentificacion")
	public String numero;
	
	public Identificacion(){};
	
	public Identificacion(TipoIdentificacion tipo, String numero) {
		this.tipo = tipo;
		this.numero = numero;
	}
	

	public TipoIdentificacion getTipo() {
		return tipo;
	}
	public void setTipo(TipoIdentificacion tipo) {
		this.tipo = tipo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}


}
