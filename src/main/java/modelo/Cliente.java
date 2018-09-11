package modelo;

import modelo.TuplaDouble;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id @GeneratedValue
	@Column (name = "cliente_id")
	private int id;
	@OneToOne(fetch = FetchType.LAZY, cascade ={CascadeType.PERSIST,CascadeType.REMOVE})                                  
	private Identificacion identificacion;
	@Column(length=15)
    private String nombre;
	@Column(length=20)
    private String apellido;
    private int telefono;
    @Column(length=30)
    private String domicilio;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private CategoriaResidencial categoria;
    @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Usuario usuario;
    private int puntos;
    @Transient //para pruebas
    @OneToMany @JoinColumn(name = "cliente_id")
    private List<DispositivoEstandar> dispositivosEstandares = new ArrayList<DispositivoEstandar>();
    @Transient //para pruebas
    @OneToMany @JoinColumn(name = "cliente_id")
    private List<DispositivoInteligente> dispositivosInteligentes = new ArrayList<DispositivoInteligente>();
    private Double consumoTotal;
    @Transient
    public TuplaDouble ubicacion;
    public List<Sensor> sensores = new ArrayList<Sensor>();

    public Cliente() {}

    public Cliente(String nombre, String apellido, TipoIdentificacion tipoId, Integer numId, Integer tel, String dom,
                   String nombreUsuario, String contrasena, int puntaje) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = new Identificacion(tipoId, numId);
        this.telefono = tel;
        this.domicilio = dom;
        this.usuario = new Usuario(nombreUsuario, contrasena,LocalDate.now());
        this.categoria = new CategoriaResidencial("r1", 0.0, 150.0, 18.76, 0.644);
        this.puntos = puntaje;
    }


    public void agregarDispositivoInteligente(DispositivoInteligente d) {
        this.dispositivosInteligentes.add(d);
        puntos += 15;
    }

    public void agregarDispositivoEstandar(DispositivoEstandar d) {
        this.dispositivosEstandares.add(d);
    }

    private int cantidadDeDispositivosEnEstado(Estado estado) {
        return (int) this.dispositivosInteligentes.stream().filter(d -> d.getEstado() == estado).count();
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

    public boolean algunDispositivoEncendido() {
        return this.cantidadDeDispositivosEncendidos() > 0;
    }

    public int cantidadDeDispositivos() {
        return this.dispositivosEstandares.size() + this.dispositivosInteligentes.size();
    }

    public double getConsumoMensual() {
        List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
        dispositivos.addAll(dispositivosEstandares);
        dispositivos.addAll(dispositivosInteligentes);
        return dispositivos.stream().mapToDouble(d -> d.getConsumoMensual()).sum();
    }

    public double getFacturaMensual(Integer mes) {
        return categoria.getCargoFijo() + categoria.getCargoVariable() * this.getConsumoMensual();
    }

    public void ligarModuloAdaptador(DispositivoEstandar d) {
        DispositivoInteligente d2 = new DispositivoInteligente(d.getNombre(), d.getBajoConsumo(), d.getKwh());
        dispositivosInteligentes.add(d2);
        dispositivosEstandares.remove(d);
        puntos += 10;
    }

    public double getConsumoInstantaneo() {
        return getDispositivos().stream().mapToDouble(d -> d.getConsumoInstantaneo()).sum();
    }


    //GETTERS AND SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return this.identificacion.getTipo();
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.identificacion.setTipo(tipoIdentificacion);
    }

    public int getNumeroIdentificacion() {
        return this.identificacion.getNumero();
    }

    public void setNumeroIdentificacion(int numeroIdentificacion) {
        this.identificacion.setNumero(numeroIdentificacion);
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public LocalDate getFechaAltaServicio() {
        return this.usuario.getFechaAltaServicio();
    }

    public void setFechaAltaServicio(LocalDate fechaAltaServicio) {
        this.usuario.setFechaAltaServicio(fechaAltaServicio);
    }

    public CategoriaResidencial getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaResidencial categoria) {
        this.categoria = categoria;
    }

    public String getNombreUsuario() {
        return this.usuario.getNombre();
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.usuario.setNombre(nombreUsuario);
    }

    public String getContrasena() {
        return this.usuario.getContrasenia();
    }

    public void setContrasena(String contrasena) {
        this.usuario.setContrasenia(contrasena);
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public List<DispositivoEstandar> getDispositivosEstandares() {
        return dispositivosEstandares;
    }

    public void setDispositivosEstandares(List<DispositivoEstandar> dispositivosEstandares) {
        this.dispositivosEstandares = dispositivosEstandares;
    }

    public List<DispositivoInteligente> getDispositivosInteligentes() {
        return dispositivosInteligentes;
    }

    public List<Dispositivo> getDispositivos() {
        List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
        dispositivos.addAll(dispositivosEstandares);
        dispositivos.addAll(dispositivosInteligentes);
        return dispositivos;
    }

    public void setDispositivosInteligentes(List<DispositivoInteligente> dispositivosInteligentes) {
        this.dispositivosInteligentes = dispositivosInteligentes;
    }

    public Double getConsumoTotal() {
        return consumoTotal;
    }

    public void setConsumoTotal(Double consumoTotal) {
        this.consumoTotal = consumoTotal;
    }

    public TuplaDouble getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(TuplaDouble ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    public void addSensor(Sensor sensor) {
        this.sensores.add(sensor);
    }

    public void ejecutarReglasDeSensores() {
        sensores.forEach(sensor -> sensor.EjecutarReglasAsociadas());
    }
}