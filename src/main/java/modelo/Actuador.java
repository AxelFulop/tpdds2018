package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class  Actuador {

	public List<DispositivoInteligente> dispositivos;

	public Actuador (List<DispositivoInteligente> dispositivos)
	{
		this.dispositivos = dispositivos;
	}
	public void ejecutarAccion(){

	}
}

//Ejemplos de actuadores: SubirTemperatura, EncenderLuces