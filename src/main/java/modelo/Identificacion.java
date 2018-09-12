package modelo;

import javax.persistence.*;

@Entity
@Embeddable
@Table(name = "identificacion")
public class Identificacion {
	@Id @GeneratedValue
	public int id;
	@Enumerated(EnumType.STRING)// @Convert(converter = ConversorTipoId.class): Para el que hizo esto, son la anottation Enumerated, hace lo mismo y definis el ttipo de dato que queres que persista en la BD
	@Embedded
	public TipoIdentificacion tipo;
	public String numero;
	
	public Identificacion(){};
	
	public Identificacion(TipoIdentificacion tipo, String numero) {
		super();
		this.tipo = tipo;
		this.numero = numero;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
