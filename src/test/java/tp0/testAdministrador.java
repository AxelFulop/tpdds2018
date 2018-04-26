package tp0;


import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import modelo.Administrador;
import modelo.repositorios.RepositorioClientes;
public class testAdministrador {
	Administrador administrador =  new Administrador("Juan","Pepito", 235545, "Juancito","soyelmejor", "2017-12-31" );
	Administrador administrador2 =  new Administrador("Pedro","hwas", 235667, "Pedrito","01234", "2018-04-20" );
	Administrador administrador3 =  new Administrador("Eduardo","Perez", 235256, "Eduardito","1111", "2016-04-25" );
	
	@Test
	public void siendoAdminDurante3meses() throws IOException {
		int	meses =administrador.cantMesesComoAdmin();
		Assert.assertEquals(meses, 3);
	}
	@Test
	public void siendoAdminDuranteElMismoMes() throws IOException {
		int meses =administrador2.cantMesesComoAdmin();
		Assert.assertEquals(meses, 0);
	}
	@Test
	public void siendoAdminDuranteDosAños() throws IOException {
	int meses =administrador3.cantMesesComoAdmin();
	Assert.assertEquals(meses, 24);
	}
	
}