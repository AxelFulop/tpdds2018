package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class  Actuador {

	public List<DispositivoInteligente> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<DispositivoInteligente> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public List<DispositivoInteligente> dispositivos;

	public Actuador (List<DispositivoInteligente> dispositivos)
	{
		this.dispositivos = dispositivos;
	}
	public void ejecutarAccion(DispositivoInteligente d){

	}
}

//Ejemplos de actuadores: SubirTemperatura, EncenderLuces