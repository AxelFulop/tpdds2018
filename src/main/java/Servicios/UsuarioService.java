package Servicios;

import java.util.List;
import javax.persistence.Query;
import modelo.Usuario;

	public class UsuarioService {
		
		
		public Usuario obtenerUsuarioPorId(int id)
		{
		return Session.getSession().find(Usuario.class,id);
		}
		

	    public Usuario obtenerUsuarioPorUserName(String username)
	    {
	    Query query = Session.getSession().createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :nomUsuario");
	    query.setParameter("nomUsuario", username);
	    List<Usuario> users = query.getResultList();
	    return users.get(0);
	    }
		
	    
	    /* public boolean esUsuarioValido(String userName,String password){
	     * Usuario user = this. obtenerUsuarioPorUserName(userName);
	     * if(user != null)
	     * {
	     * return (user.getNombreUsuario() == username && user.getContrasenia() == password);
	     * }
	     * else
	     * {
	     * return false;
	     * }
	     */
	}
	

	


