package modelo;

public class DispositivoEstandar implements Dispositivo {
	private String nombre;
	private int kwh;
	private int horasDeUsoDiarias; //Estimativo brindado por el usuario
	
	public DispositivoEstandar(String nom, int consumo) {
		nombre = nom;
		kwh = consumo;
	}
	
	public double getConsumoMensual() {
		return (double) (kwh * horasDeUsoDiarias * 30);
	}
	
	//GETTERS Y SETTERS

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getKwh() {
		return kwh;
	}

	public void setKwh(int kwh) {
		this.kwh = kwh;
	}

	public int getHorasDeUsoDiarias() {
		return horasDeUsoDiarias;
	}

	public void setHorasDeUsoDiarias(int horasDeUsoDiarias) {
		this.horasDeUsoDiarias = horasDeUsoDiarias;
	}
	
}
