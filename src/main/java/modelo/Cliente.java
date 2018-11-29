package modelo;

import Servicios.Session;
import common.Coordenada;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Cliente extends Usuario {
	int telefono;
    String domicilio;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private CategoriaResidencial categoria;
    private int puntos;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private List<DispositivoEstandar> dispositivosEstandares = new ArrayList<DispositivoEstandar>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private List<DispositivoInteligente> dispositivosInteligentes = new ArrayList<DispositivoInteligente>();
    private Double consumoTotal;
    @Embedded
    public Coordenada ubicacion;
    @OneToMany
    @JoinColumn(name = "cliente_id")
    public List<Sensor> sensores = new ArrayList<Sensor>();



    public Cliente() {
    }

    public Cliente(String nombre, String apellido, TipoIdentificacion tipoIdentificacion, String numId, Integer tel, String dom,
                   String nombreUsuario, String contrasenia, int puntaje) {
        super(nombreUsuario, contrasenia, nombre, apellido,tipoIdentificacion,numId);
        this.telefono = tel;
        this.domicilio = dom;
        this.categoria = new CategoriaResidencial("r1", 0.0, 150.0, 18.76, 0.644);
        this.puntos = puntaje;
    }

    @Override
	public String toString() {
		return "Cliente [id=" + this.getId() + ", nombreUsuario=" + this.nombreUsuario + ", contrasenia=" + this.contrasenia + ", telefono=" + telefono + ", domicilio=" + domicilio + ", categoria=" + categoria + ", puntos="
				+ puntos + ", dispositivosEstandares=" + dispositivosEstandares + ", dispositivosInteligentes="
				+ dispositivosInteligentes + ", consumoTotal=" + consumoTotal + ", ubicacion=" + ubicacion
				+ ", sensores=" + sensores + "]";
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

    public Double getConsumoMensual() {
        List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
        dispositivos.addAll(dispositivosEstandares);
        dispositivos.addAll(dispositivosInteligentes);
        return dispositivos.stream().mapToDouble(d -> d.getConsumoMensual()).sum();
    }

    public Double getFacturaMensual(Integer mes) {
        return categoria.getCargoFijo() + categoria.getCargoVariable() * this.getConsumoMensual();
    }

    public void ligarModuloAdaptador(DispositivoEstandar d) {
        DispositivoInteligente d2 = new DispositivoInteligente(d.getNombre(), d.getBajoConsumo(), d.getKwh());
        dispositivosInteligentes.add(d2);
        dispositivosEstandares.remove(d);
        puntos += 10;
    }

    public Double getConsumoInstantaneo() {
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

    public String getNumeroIdentificacion() {
        return this.identificacion.getNumero();
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
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

    public Date getFechaAltaServicio() {
        return this.getFechaAltaServicio();
    }

    public void setFechaAltaServicio(Date fechaAltaServicio) {
        this.setFechaAltaServicio(fechaAltaServicio);
    }

    public CategoriaResidencial getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaResidencial categoria) {
        this.categoria = categoria;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return this.contrasenia;
    }

    public void setContrasena(String contrasena) {
        this.contrasenia = contrasena;
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

    public Coordenada getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Coordenada ubicacion) {
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

    public static Cliente buscarPorId(int id)
    {
        return Session.getSession().find(Cliente.class,id);
    }
    public static List<Cliente> obtenerTodos() {
        return (List<Cliente>) Session.getSession().createQuery("SELECT e FROM Cliente e").getResultList();
    }
    
    public boolean tieneDispositivo(Dispositivo disp) {
    	boolean retorno = this.dispositivosEstandares.stream().anyMatch(d -> d.getId() == disp.getId());
    	if(!retorno) {
    		retorno = this.dispositivosInteligentes.stream().anyMatch(d -> d.getId() == disp.getId());
    	}
    	return retorno;
    }
}