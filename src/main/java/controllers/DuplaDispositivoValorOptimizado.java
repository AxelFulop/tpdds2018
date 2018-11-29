package controllers;

public class DuplaDispositivoValorOptimizado {
	private String nombreDispositivo;
	private Double valorOptimizado;
	
	public DuplaDispositivoValorOptimizado(String d, Double v) {
		this.nombreDispositivo = d;
		this.valorOptimizado = v;
	}

	public DuplaDispositivoValorOptimizado() {}
	
	public String getNombreDispositivo() {
		return nombreDispositivo;
	}

	public void setNombreDispositivo(String nombreDispositivo) {
		this.nombreDispositivo = nombreDispositivo;
	}

	public Double getValorOptimizado() {
		return valorOptimizado;
	}

	public void setValorOptimizado(Double valorOptimizado) {
		this.valorOptimizado = valorOptimizado;
	}
	
	
}
