package Servicios;

import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.Dispositivo;

public class AdministradorService {
	
	//hogar = cliente
	public List<Cliente> obtenerHogares() {
		List<Cliente> listaHogares = new ArrayList<Cliente>();
		listaHogares = (List<Cliente>) Session.getSession().createQuery("from Cliente").getResultList();		
		return listaHogares;
	}
	
	public void darAltaDispositivo(Dispositivo d) {
		Session.beginTransaction();
		try {
			Session.getSession().persist(d);
			Session.commitTransaction();
		}catch(Exception e) {
			Session.rollbackTransaction();
		}
		
	}
}
