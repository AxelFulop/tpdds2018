package modelo;

import Servicios.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Actuador extends Model {
	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany
	@JoinTable(name = "actuadorPorDispositivoInteligente",
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
	public void agregarDispositivo(DispositivoInteligente d)
	{
		this.dispositivos.add(d);
	}
}

//Ejemplos de actuadores: SubirTemperatura, EncenderLuces