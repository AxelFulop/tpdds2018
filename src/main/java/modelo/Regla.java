package modelo;

import Servicios.Model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Regla extends Model {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;

	@OneToOne(cascade = CascadeType.ALL) @JoinColumn(name = "actuador_id")
    public Actuador actuador;

    public Regla(){

    }
    
    public Regla(Actuador actuador, String nombre) {
        this.actuador = actuador;
        this.nombre = nombre;
    }
    
    public Actuador getActuador() {
        return actuador;
    }

    public void setActuador(Actuador actuador) {
        this.actuador = actuador;
    }

    public void llamarActuador(DispositivoInteligente dispositivoAComparar,double medicion) {

    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
