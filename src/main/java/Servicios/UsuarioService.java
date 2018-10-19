package Servicios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Cliente;
import modelo.DispositivoEstandar;
import modelo.DispositivoInteligente;
import modelo.Usuario;

	public class UsuarioService extends Model {

		public static void eliminar(Usuario usuario) {
			try {
				Session.beginTransaction();
				Session.getSession().remove(usuario);
				Session.commitTransaction();
			} catch (Exception e) {
				e.printStackTrace();
				Session.rollbackTransaction();
			}
		}

		public static void persistir(Usuario usuario) {
			try {
				Session.beginTransaction();
				Session.getSession().persist(usuario);
				Session.commitTransaction();
			} catch (Exception e) {
				e.printStackTrace();
				Session.rollbackTransaction();
			}
		}

		public static void actualizar(Usuario usuario) {
			try {
				Session.beginTransaction();
				Session.getSession().merge(usuario); //TODO: Quitar esto
				Session.commitTransaction();
			} catch (Exception e) {
				e.printStackTrace();
				Session.rollbackTransaction();
			}
		}
		public static Usuario obtenerUsuarioPorId(int id)
		{
		return Session.getSession().find(Usuario.class,id);
		}



	    public static Usuario obtenerUsuario(String username,String password)
	    {
	    Usuario user = null; 
	    try{
	    Query query = Session.getSession().createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :nomUsuario and u.contrasenia = :pass");
	    query.setParameter("nomUsuario", username);
	    query.setParameter("pass",password);
	    query.setMaxResults(1);
	    user = (Usuario) query.getSingleResult();
	    }
	    catch(NoResultException e){
	    e.toString();
	    }
	    return user;
	    }
		
		public static List<DispositivoInteligente> obtenerDispositivosInteligentes(String username,String password)
		{
			Query query = Session.getSession().createQuery("SELECT c.dispositivosInteligentes FROM Cliente c WHERE c.nombreUsuario = :nomUsuario and c.contrasenia = :pass");
		    query.setParameter("nomUsuario", username);
		    query.setParameter("pass", password);
		    List<DispositivoInteligente> dispInteligente =  query.getResultList();
		    return dispInteligente;
			
		}
		
		
		public static List<DispositivoEstandar> obtenerDispositivosEstandar(String username,String password)
		{
			Query query = Session.getSession().createQuery("SELECT c.dispositivosEstandares FROM Cliente c WHERE c.nombreUsuario = :nomUsuario and c.contrasenia = :pass");
		    query.setParameter("nomUsuario", username);
		    query.setParameter("pass", password);
		    List<DispositivoEstandar> dispEstandar =  query.getResultList();
		    return dispEstandar;
			
		}
	
		//hogar = cliente
		public static List<Cliente> obtenerHogares() {
			List<Cliente> listaHogares = new ArrayList<Cliente>();
			listaHogares = (List<Cliente>) Session.getSession().createQuery("from Cliente").getResultList();		
			return listaHogares;
		}
	     
}
	

	


