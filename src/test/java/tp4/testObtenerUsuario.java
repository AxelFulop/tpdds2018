package tp4;

import org.junit.Test;


import Servicios.UsuarioService;
import modelo.Cliente;
import modelo.TipoIdentificacion;
import modelo.Usuario;

public class testObtenerUsuario {
	@Test
	public void persistoUsuarioYLoObtengo(){
	Cliente cliente3= new Cliente("nicolas","fulop",TipoIdentificacion.DNI,"123",48262937,"Medrano 951","nico","asd",0);
    cliente3.persistir();
    UsuarioService userService = new UsuarioService();
    Usuario user = userService.obtenerUsuarioPorUserName("nico");
    org.junit.Assert.assertEquals(user.getNombreUsuario(),"nico");
}
}
