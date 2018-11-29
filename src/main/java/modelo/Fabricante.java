package modelo;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Fabricante {

	@Id
	@GeneratedValue
	protected Long id;
	public String name;

	public Fabricante(){

	}
	
	public void setNombre(String nom) {
		this.name = nom;
	}
	
	public String getNombre() {
		return this.name;
	}
	
	public float obtenerConsumoUltimasHoras(Integer h){
		return 0;
	};
	
}

//Habra un adaptar por c/ fabricante dependiendo de cómo sea su diálogo con el dispositivo y el formato del valor que devuelve