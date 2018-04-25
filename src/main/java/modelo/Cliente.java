package modelo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import modelo.repositorios.RepositorioClientes;

public class Cliente {
	private String nombre;
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private String apellido;
	private TipoIdentificacion tipoIdentificacion;
	private int numeroIdentificacion;
	private int telefono;
	private String domicilio;
	private LocalDate fechaAltaServicio;
	private Categoria categoria;
	private String nombreUsuario;
	private String contrasena;
	private List<Dispositivo> dispositivos = new ArrayList<>();
	private Double consumoTotal;
	
	

	
	
	public Cliente(String nombre,String apellido,TipoIdentificacion tipoId,String nombreUsuario,String contrasena) {
		this.fechaAltaServicio = LocalDate.now();
		this.nombre=nombre;
		this.apellido=apellido;
		this.tipoIdentificacion=tipoId;
		this.nombreUsuario=nombreUsuario;
		this.contrasena=contrasena;
		
		}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	//No tendría que agregarlo el administrador??
	/*
	public void agregarClienteAlRepositorio(){
		RepositorioClientes.getInstance().addCliente(this);
	}*/
	
	public void agregarDispositivo(Dispositivo disp) {
		this.dispositivos.add(disp);
	}
	
	
	/*public int consumoDeLosEncendidos() {
		return this.cualesEncendidos().stream()
				.mapToInt(dispo -> dispo.getKwh()).sum();
	}*/

	

	public boolean estadoDispositivo(Dispositivo dispositivo) {
		return dispositivo.getEstado();
	}
 	
	public int cantidadDeDispositivosEnEstado(Boolean estado) {
		return (int) this.getDispositivos().stream().filter(dispositivo -> dispositivo.getEstado()==estado).count();
	}
	
	public boolean algunDispostivoEncendido(List<Dispositivo> dispositivos) {
		Predicate<Dispositivo> p1 = d -> d.getEstado() == true;
		return (boolean) this.getDispositivos().stream().anyMatch(p1);
	}

	public int cantidadDeDispositivos() {
		return this.dispositivos.size();
	}
	
	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<Dispositivo> dispositivos) {
		dispositivos.forEach(d->this.dispositivos.add(d));;
	}
	
	public void setDispositivo(Dispositivo dispositivo) {
		dispositivos.add(dispositivo);
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Double getConsumoMensual(Integer mes) {
		
		consumoTotal= (double) 0;
		this.dispositivos.forEach(c->consumoTotal=consumoTotal+c.getConsumoEnHorasAlMes(mes));
		return consumoTotal;
		
	}
	
	public void categorizarme()
	{
		new Categorizador().categorizar(this,LocalDate.now().getMonthValue());
	}
	
	
	
	
}
