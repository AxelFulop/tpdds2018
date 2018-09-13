package modelo;

//import org.uqbar.commons.utils.Observable;

import Servicios.Controller;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
//@Observable
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Actuador extends Controller {
	@Id
	@GeneratedValue
	private int id;

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