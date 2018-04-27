package modelo;


public class CategoriaResidencial {
	private String nombre;
	private Double limiteInferior;
	private Double limiteSuperior;
	private Double cargoFijo;
	private Double cargoVariable;
	
	public CategoriaResidencial(String nom, Double limInf, Double limSup, Double cFijo, Double cVariable) {
		nombre = nom;
		limiteInferior = limInf;
		limiteSuperior = limSup;
		cargoFijo = cFijo;
		cargoVariable = cVariable;
	}
	
	public String getNombre() {
		return nombre;
	}
	public Double getLimiteSuperior() {
		return limiteSuperior;
	}
	
	public Double getLimiteInferior() {
		return limiteInferior;
	}
	
	public Double getCargoVariable() {
		return this.cargoVariable;
	}
	
	public Double getCargoFijo() {
		return this.cargoFijo;
	}
	
	public boolean pertenece(Cliente unCliente) {
		return unCliente.getConsumoMensual() > limiteInferior &&
			   unCliente.getConsumoMensual() <= limiteSuperior;
	}
	
}
