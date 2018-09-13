package tp1;

import modelo.TipoIdentificacion;
import org.junit.Assert;
import org.junit.Test;
import modelo.Administrador;

public class testAdministrador {
	Administrador administrador =  new Administrador("Juan","Pepito", "Juancito","soyelmejor",TipoIdentificacion.CI,"2223dsf");

	@Test
	public void siendoAdminDuranteElMismoMes()  {
		int meses =administrador.candidaDeMesesComoAdministrator();
		Assert.assertEquals(meses, 0);
	}

	
}