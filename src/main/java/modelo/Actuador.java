package modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public abstract class Actuador {
	@Id
	@GeneratedValue
	private int id;

	@ManyToMany
	@JoinTable(name = "actuador_id",
			joinColumns = @JoinColumn(name = "dispositivoInteligente_id"),
			inverseJoinColumns = @JoinColumn(name = "actuador_id")
	)
	public List<DispositivoInteligente> dispositivos;

	public Actuador(){}
	public List<DispositivoInteligente> getDispositivos() {
		return dispositivos;
	}
	public void setDispositivos(List<DispositivoInteligente> dispositivos) {
		this.dispositivos = dispositivos;
	}
	public Actuador (List<DispositivoInteligente> dispositivos)
	{
		this.dispositivos = dispositivos;
	}
	public void ejecutarAccion(DispositivoInteligente d){

	}
}

//Ejemplos de actuadores: SubirTemperatura, EncenderLuces