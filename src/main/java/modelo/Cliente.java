package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
	private int puntos;
	private List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
	private Double consumoTotal;

	public Cliente() {
	}

	public Cliente(String nombre, String apellido, TipoIdentificacion tipoId, Integer numId, Integer tel, String dom,
			String nombreUsuario, String contrasena, int puntaje) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoIdentificacion = tipoId;
		this.numeroIdentificacion = numId;
		this.telefono = tel;
		this.domicilio = dom;
		this.fechaAltaServicio = LocalDate.now();
		this.categoria = new CategoriaResidencial("r1", 0.0, 150.0, 18.76, 0.644);
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.puntos = puntaje;
	}

	public void agregarDispositivo(Dispositivo disp) {
		this.dispositivos.add(disp);
		if (disp.esInteligente()) {
			this.sumarPuntos(15);
		}
	}

	public void adaptarDispositivoEstandar(Dispositivo disp) {
		if (!disp.esInteligente()) {
			disp.convertirAInteligente();
			this.sumarPuntos(10);
		}
	}

	public void sumarPuntos(int puntos) {
		this.puntos += puntos;
	}

	public int puntaje() {
		return puntos;
	}

	public void setHorasDeUsoDelDia(Dispositivo dispositivo, int horas) {
		dispositivo.setHorasEnUsoDelDia(horas);
	}

	private int cantidadDeDispositivosEnEstado(Estado estado) {
		return (int) this.dispositivos.stream().filter(d -> d.esInteligente()).filter(di -> di.estado() == estado)
				.count();
	}

	public int cantidadDeDispositivosEncendidos() {
		return this.cantidadDeDispositivosEnEstado(Estado.ENCENDIDO);
	}

	public int cantidadDeDispositivosApagados() {
		return this.cantidadDeDispositivosEnEstado(Estado.APAGADO);
	}

	public int cantidadDeDispositivosEnAhorroDeEnergia() {
		return this.cantidadDeDispositivosEnEstado(Estado.AHORROENERGIA);
	}

	public int cantidadDeDispositivos() {
		return this.dispositivos.size();
	}

	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public List<Dispositivo> getDispositivosInteligentes() {
		return this.dispositivos.stream().filter(d -> d.esInteligente()).collect(Collectors.toList());
	}

	public void agregarDispositivos(List<Dispositivo> dispositivos) {
		dispositivos.forEach(d -> this.agregarDispositivo(d));
	}

	public CategoriaResidencial getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaResidencial categoria) {
		this.categoria = categoria;
	}

	public Double getConsumoMensual() {
		consumoTotal = (double) 0;
		this.dispositivos.forEach(c -> consumoTotal = consumoTotal + c.getConsumoDeKwMensual());
		return consumoTotal;
	}

	public Double getFacturaMensual(Integer mes) {
		return categoria.getCargoFijo() + categoria.getCargoVariable() * this.getConsumoMensual();
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public TipoIdentificacion getTipoIdentificacion() {
		return tipoIdentificacion;
	}


	public int getNumeroIdentificacion() {
		return numeroIdentificacion;
	}


	public int getTelefono() {
		return telefono;
	}


	public String getDomicilio() {
		return domicilio;
	}

	public LocalDate getFechaAltaServicio() {
		return fechaAltaServicio;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public String getContrasena() {
		return contrasena;
	}


	public int getPuntos() {
		return puntos;
	}


}