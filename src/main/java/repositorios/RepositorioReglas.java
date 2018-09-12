package repositorios;

import java.util.List;

import modelo.Regla;

public class RepositorioReglas {
	public static RepositorioReglas instancia = new RepositorioReglas();
	public static List<Regla> allReglas;
	
	private RepositorioReglas() { }

	public static RepositorioReglas getInstancia() {
		return instancia;
	}
	
	public List<Regla> getReglas() {
		return allReglas;
	}

	public void addRegla(Regla regla) {
		RepositorioReglas.allReglas.add(regla);
	}	
}
