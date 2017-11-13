package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

public class DadoCubicoTest {

	@Test
	public void testCrearUnDadoCubicoNoEsNull() {
		Lanzable dado = new DadoCargado(2);
		Assert.assertNotEquals(null, dado);
	}

	@Test
	public void testLanzarUnDadoCubico100000VecesSiempreDaUnValorEntre1y6() {
		Lanzable dado = new DadoCubico();
		for(int i = 0;i<100000;i++) {
			dado.lanzar();
			int valor_obtenido = dado.obtenerValor();
			if(valor_obtenido > 6) fail();
			if(valor_obtenido < 1) fail();
		}
	}

}
