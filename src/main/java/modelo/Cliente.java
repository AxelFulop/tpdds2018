package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.AdaptadorInteligente.Estado;

public class Cliente {
	private String nombre;
	private String apellido;
	private TipoIdentificacion tipoIdentificacion;
	private int numeroIdentificacion;
	private int telefono;
	private String domicilio;
	private LocalDate fechaAltaServicio;
	private CategoriaResidencial categoria;
	private String nombreUsuario;
	private String contrasena;
	
	private List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
	private List<Actuador> actuadores = new ArrayList<Actuador>();
	private Double consumoTotal;
	public Cliente() {
	}
	public Cliente(String nombre,String apellido,TipoIdentificacion tipoId, Integer numId, Integer tel, String dom,String nombreUsuario,String contrasena) {
			
			this.nombre=nombre;
			this.apellido=apellido;
			this.tipoIdentificacion=tipoId;
			this.numeroIdentificacion = numId;
			this.telefono = tel;
			this.domicilio = dom;
			this.fechaAltaServicio = LocalDate.now();
			this.categoria = new CategoriaResidencial("r1",0.0, 150.0, 18.76, 0.644);
			this.nombreUsuario=nombreUsuario;
			this.contrasena=contrasena;
			
			}	
	
		
	public void agregarDispositivo(Dispositivo disp) {
		this.dispositivos.add(disp);
	}
 	
	private int cantidadDeDispositivosEnEstado(Estado estado) {
		return (int) this.dispositivos.stream().filter(d -> d.adaptadorInteligente!=null).filter(di -> di.adaptadorInteligente.getEstado() == estado).count();
	}
	
	public int cantidadDeDispositivosEncendidos() {
		return this.cantidadDeDispositivosEnEstado(Estado.ENCENDIDO);
	}
	
	public int cantidadDeDispositivosApagados() {
		return this.cantidadDeDispositivosEnEstado(Estado.APAGADO);
	}
	
	

	public String getNombre() {
		return nombre;
	}
	public int cantidadDeDispositivos() {
		return this.dispositivos.size();
	}
	
	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void agregarDispositivos(List<Dispositivo> dispositivos) {
		dispositivos.forEach(d->this.agregarDispositivo(d));
	}
	
	public CategoriaResidencial getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaResidencial categoria) {
		this.categoria = categoria;
	}
	
	public Double getConsumoMensual() {	
		consumoTotal = (double) 0;
		this.dispositivos.forEach(c -> consumoTotal=consumoTotal + c.getConsumoDeKwMensual());
		return consumoTotal;
	}
	
	
	
	public Double getFacturaMensual(Integer mes) {
		return categoria.getCargoFijo() + categoria.getCargoVariable() * this.getConsumoMensual(); 
	}
	
	public void ejecutarActuadores() {
		actuadores.forEach(a -> a.ejecutar());
	}
	public boolean algunDispostivoEncendido() {
		// TODO Auto-generated method stub
		return dispositivos.stream().anyMatch(d -> d.getAdaptadorInteligente().estado == Estado.ENCENDIDO);
	}
	public List<Actuador> getActuadores() {
		return actuadores;
	}
	public void setActuadores(List<Actuador> actuadores) {
		this.actuadores = actuadores;
	}
	
	
	
	
}
