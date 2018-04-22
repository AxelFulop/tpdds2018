package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import modelo.repositorios.RepositorioClientes;

public class Cliente {
	private String nombre;
	private String apellido;
	private TipoIdentificacion tipoIdentificacion;
	private int numeroIdentificacion;
	private int telefono;
	private String domicilio;
	private LocalDate fechaAltaServicio;
	private Categoria categoria;
	private String nombreUsuario;
	private String contrasena;
	private List<Dispositivo> dispositivos;
	
	public Cliente(String nombre,String apellido,TipoIdentificacion tipoId,String nombreUsuario,String contrasena) {
		this.fechaAltaServicio = LocalDate.now();
		this.nombre=nombre;
		this.apellido=apellido;
		this.tipoIdentificacion=tipoId;
		this.nombreUsuario=nombreUsuario;
		this.contrasena=contrasena;
		}

	public void agregarClienteAlRepositorio(){
		RepositorioClientes.getInstancia().addCliente(this);
	}
	
	public void agregarDispositivo(Dispositivo disp) {
		this.dispositivos.add(disp);
	}
	
	public boolean estadoDispositivo(Dispositivo dispositivo) {
		return dispositivo.getEstado();
	}
	
	public int cantidadDeDispositivosEnEstado(Boolean estado) {
			return (int) this.getDispositivos().stream().filter(dispositivo -> dispositivo.getEstado()==estado).count();
	}
	
	public int cantidadDeDispositivos() {
		return this.dispositivos.size();
	}
	
	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}
	
	public int consumoMensual() {
		int consumoTotal = 0;
		for(Dispositivo d : this.dispositivos){
			if(d.getEstado()) {		
			consumoTotal += d.getKwh();
			}
		}
		return consumoTotal;
	}
	
	public double facturaMensual() {
		return categoria.cargoFijo() + this.consumoMensual()*categoria.cargoVariable();
	}
	
	
	
}
