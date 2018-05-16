package modelo;

public class AdaptadorInteligente {

	//public static enum Estado{ENCENDIDO,APAGADO,AHORROENERGIA};
	private Estado estado;
	float horasEnUso;
	
	
	public AdaptadorInteligente ()
	{
		apagar();
	}
	/*
	public Estado getEstado() {
		return estado;
	}*/
	public void setEstado(Estado estado){
		this.estado = estado;
	}
	
	public String estado(){
		return estado.nombre();
		
	};
		
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
		this.setEstado(new apagado());
	}
	public void encender() {
		this.setEstado(new prendido());
	}
	/*public void establecerModoAhorro()
	{
		this.estado = Estado.AHORROENERGIA;
	}*/
}
