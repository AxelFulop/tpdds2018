package Servicios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import modelo.Cliente;
import modelo.Dispositivo;
import modelo.DispositivoEstandar;
import modelo.DispositivoInteligente;
import modelo.Usuario;

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
