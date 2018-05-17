package tp1;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import modelo.Administrador;

public class testAdministrador {
	Administrador administrador =  new Administrador("Juan","Pepito", 235545, "Juancito","soyelmejor", LocalDate.now().minusMonths(3) );
	Administrador administrador2 =  new Administrador("Pedro","hwas", 235667, "Pedrito","01234", LocalDate.now().minusDays(3) );
	Administrador administrador3 =  new Administrador("Eduardo","Perez", 235256, "Eduardito","1111", LocalDate.now().minusMonths(24) );
	
	@Test
	public void siendoAdminDurante3meses()  {
		int	meses =administrador.cantMesesComoAdmin();
		Assert.assertEquals(meses, 3);
	}
	@Test
	public void siendoAdminDuranteElMismoMes()  {
		int meses =administrador2.cantMesesComoAdmin();
		Assert.assertEquals(meses, 0);
	}
	@Test
	public void siendoAdminDuranteDosAños() {
	int meses =administrador3.cantMesesComoAdmin();
	Assert.assertEquals(meses, 24);
	}
	
}