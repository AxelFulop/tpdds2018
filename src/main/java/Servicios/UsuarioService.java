package Servicios;


import modelo.Usuario;

public class UsuarioService {
	
	
	public Usuario obtenerUsuarioPorId(int id)
	{
	return Session.getSession().find(Usuario.class,id);
	}
	

	public Usuario obtenerUsuarioPorUserName(String userName)
	{
	return Session.getSession().find(Usuario.class,userName);
	}
	
	public boolean existeUsuario(String userName){
		
		return !obtenerUsuarioPorUserName(userName).equals(null);
		
		
	}
	
	public boolean validarUsuario(String userName,String password)
	{
		
		Usuario user = this.obtenerUsuarioPorUserName(userName);
		String passwordHasheada =SHA256Builder.generarHash256(password);
		return user.getContrasenia().equals(passwordHasheada);

	}
	}


