package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
		
	public void agregarDispositivo(Dispositivo disp) {
		this.dispositivos.add(disp);
	}
 	
	public int cantidadDeDispositivosEnEstado(Boolean estado) {
		return (int) this.dispositivos.stream().filter(d -> d.estaEncendido() == estado).count();
	}
	
	public int cantidadDeDispositivosEncendidos() {
		return this.cantidadDeDispositivosEnEstado(true);
	}
	
	public int cantidadDeDispositivosApagados() {
		return this.cantidadDeDispositivosEnEstado(false);
	}
	
	public boolean algunDispostivoEncendido() {
		return this.dispositivos.stream().anyMatch(d -> d.estaEncendido());
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
	
	public Double getConsumoMensual(Integer mes) {	
		consumoTotal = (double) 0;
		this.dispositivos.forEach(c -> consumoTotal=consumoTotal + c.getConsumoEnHorasAlMes(mes));
		return consumoTotal;
	}
	
	// ¿Un metodo que llama a otro? ¿Por qué es necesario?
	// Un cliente no necesita 
	/*public void reCategorizarme()
	{
		new Categorizador().recategorizar(this);
	}
	*/
	
	public Double getFacturaMensual(Integer mes) {
		return categoria.getCargoFijo() + categoria.getCargoVariable() * this.getConsumoMensual(mes); 
	}
	
}
