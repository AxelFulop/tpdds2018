package modelo;

public class DispositivoInteligente implements Dispositivo {
private String nombre;
private Estado estado;
private Fabricante fabricante;

	public DispositivoInteligente(String nom) {
		setNombre(nom);
		estado = Estado.ENCENDIDO;
	}
	
	public boolean estaEncendido() {
		return estado == Estado.ENCENDIDO;
	}

	public boolean estaApagado() {
		return estado == Estado.APAGADO;
	}
	

	public float energiaEnLasUltimasHoras(Integer horas) {
		return fabricante.obtenerConsumoUltimasHoras(horas);
	}

	public void ponerseEnEstado(Estado e) {
		estado = e;
	}
	
	public void encender() {
		this.ponerseEnEstado(Estado.ENCENDIDO);
	}
	
	public void apagar() {
		this.ponerseEnEstado(Estado.APAGADO);
	}
	
	public void modoDeEnergia() {
		this.ponerseEnEstado(Estado.AHORROENERGIA);
	}
	
	@Override
	public double getConsumoMensual() {
		// TODO Auto-generated method stub
		return 0;
	}
		
	//Getters and setters
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


}
