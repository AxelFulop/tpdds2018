package sistemaDeGestionEnergetica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Cliente {
	private String nombre;
	private String apellido;
	private TipoDoc tipoDoc;
	private int nroDoc;
	private int telefono;
	private String domicilio;
	private LocalDate fechaDeAlta;
	private Categoria categoria;
	private String nombreUsuario;
	private String contraseña;
	private ArrayList<Dispositivo> dispositivos;
	
	public Cliente() {
		fechaDeAlta = LocalDate.now();
		}
	//el resto de los parametros dsp los asigno
	
	public void agregarDispositivo(Dispositivo disp) {
		this.dispositivos.add(disp);
	}
	
	public boolean estaEncendido(Dispositivo dispositivo) {
		return dispositivo.estaEncendido();
	}
	
	public int cantDispositivosEncendidos() {
		return this.dispositivosEncendidos().size();
	}
	
	public ArrayList<Dispositivo> dispositivosEncendidos() {
		ArrayList<Dispositivo> encendidos = new ArrayList<Dispositivo>();
		for(Dispositivo d:dispositivos) {
			if(d.estaEncendido()) {
				encendidos.add(d);
			}
		}		
		return encendidos;
	}
	
	public int cantDispositivosApagados() {
		return this.dispositivosApagados().size();
	}
	
	public ArrayList<Dispositivo> dispositivosApagados() {
		ArrayList<Dispositivo> apagados = new ArrayList<Dispositivo>();
		for(Dispositivo d:dispositivos) {
			if(!d.estaEncendido()) {
				apagados.add(d);
			}
		}		
		return apagados;
	}
	
	public int cantDispositivos() {
		return this.dispositivos.size();
	}
	
	
}
