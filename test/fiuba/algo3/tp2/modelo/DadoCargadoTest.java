package fiuba.algo3.tp2.modelo;

import org.junit.Test;
import org.junit.Assert;

public class DadoCargadoTest {

	private static final double DELTA = 1e-6;
	
	@Test
	public void testCrearUnDadoCargadoNoEsNull() {
		Lanzable dado = new DadoCargado(2);
		Assert.assertNotEquals(null, dado);
	}

	@Test
	public void testLanzarUnDadoCargadoCon2Saca2AlLanzarlo1000Veces() {
		Lanzable dado = new DadoCargado(2);
		for(int i = 0;i < 1000;i++) {
			dado.lanzar();
			Assert.assertEquals(2, dado.obtenerValor(), DELTA);
		}
	}
	
	@Test
	public void testLanzarUnDadoCargadoCon8Saca8AlLanzarlo1000Veces() {
		Lanzable dado = new DadoCargado(8);
		for(int i = 0;i < 1000;i++) {
			dado.lanzar();
			Assert.assertEquals(8, dado.obtenerValor(), DELTA);
		}
	}

}
