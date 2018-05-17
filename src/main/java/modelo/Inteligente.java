package modelo;

public class Inteligente {
		private Estado estado;
		
		public Inteligente()
		{
			this.estado = Estado.APAGADO;
		}
		
		public boolean esInteligente() {
			return true;
		}
		
		public Estado getEstado() {
			return estado;
		}
		
		public boolean estaEncendido() {
			return this.estado == Estado.ENCENDIDO || this.estado == Estado.AHORROENERGIA;
		}
		
		public boolean estaApagado() {
			return this.estado == Estado.APAGADO;
		}
		
		/*public boolean estaEnModoAhorroDeEnergia() {
			return this.estado == Estado.AHORROENERGIA;
		}*/
		
		public float energiaConsumidaEnUltimasHoras(int horas, Dispositivo disp) {
			if(disp.getHorasEnUsoDelDia() > horas) {
				return horas*disp.getKwh();
			}
			else {
				return disp.getHorasEnUsoDelDia()*disp.getKwh();
			}
		}
		
		public float consumoTotalEnPeriodo(int horasInicio, int horasFinal, Dispositivo disp){
			return 0; // FALTA
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
