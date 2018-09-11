package modelo;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "identificacion")
public class Identificacion {
	@Id @GeneratedValue
	@Column (name = "indentificacion_id")
	private int id;
	@Convert(converter = ConversorTipoId.class)
	@Embedded
	private TipoIdentificacion tipo;
	private int numero;
	
	public Identificacion(){};
	
	public Identificacion(TipoIdentificacion tipo, int numero) {
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
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}
