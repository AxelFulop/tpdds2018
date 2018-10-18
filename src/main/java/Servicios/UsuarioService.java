package Servicios;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.DispositivoEstandar;
import modelo.DispositivoInteligente;
import modelo.Usuario;

	public class UsuarioService {
		
		
		public Usuario obtenerUsuarioPorId(int id)
		{
		return Session.getSession().find(Usuario.class,id);
		}
		

	    public Usuario obtenerUsuario(String username,String password)
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
		
		public List<DispositivoInteligente> obtenerDispositivosInteligentes(String username,String password)
		{
			Query query = Session.getSession().createQuery("SELECT c.dispositivosInteligentes FROM Cliente c WHERE c.nombreUsuario = :nomUsuario and c.contrasenia = :pass");
		    query.setParameter("nomUsuario", username);
		    query.setParameter("pass", password);
		    List<DispositivoInteligente> dispInteligente =  query.getResultList();
		    return dispInteligente;
			
		}
		
		
		public List<DispositivoEstandar> obtenerDispositivosEstandar(String username,String password)
		{
			Query query = Session.getSession().createQuery("SELECT c.dispositivosEstandares FROM Cliente c WHERE c.nombreUsuario = :nomUsuario and c.contrasenia = :pass");
		    query.setParameter("nomUsuario", username);
		    query.setParameter("pass", password);
		    List<DispositivoEstandar> dispEstandar =  query.getResultList();
		    return dispEstandar;
			
		}
	    
	     
	}
	

	


