package modelo;

public class AdaptadorInteligente {

	public static enum Estado{ENCENDIDO,APAGADO,AHORROENERGIA};
	
	float horasEnUso;
	
	
	Estado estado;
	
	public AdaptadorInteligente ()
	{
		this.estado = Estado.APAGADO;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public float energiaConsumidaEnHoras(float horas)
	{
		return horas;
		
	}
	public float consumoTotalEnPerido()
	{
		return horasEnUso;
		
	}
	public void apagar()
	{
		this.estado = Estado.APAGADO;
	}
	public void encender() {
		this.estado = Estado.ENCENDIDO;
	}
	public void establecerModoAhorro()
	{
		this.estado = Estado.AHORROENERGIA;
	}
}
