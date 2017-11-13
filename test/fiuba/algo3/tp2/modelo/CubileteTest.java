package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Test;

public class CubileteTest {
	
	private static final double DELTA = 1e-6;

	@Test
	public void testCubilete() {
		Cubilete cubilete = new Cubilete();
		Assert.assertNotEquals(null, cubilete);
	}

	@Test
	public void testLanzarUnCubileteSinDadosObtiene0() {
		//TAL VEZ DEBERIA LANZAR UNA EXCEPCION
		Cubilete cubilete = new Cubilete();
		cubilete.lanzar();
		Assert.assertEquals(0, cubilete.sumarValores(), DELTA);
	}
	
	@Test
	public void testLanzarUnCubileteConUnDadoObtieneElValorDelDado() {
		Lanzable dado = new DadoCubico();
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado);
		cubilete.lanzar();
		Assert.assertEquals(dado.obtenerValor(), cubilete.sumarValores(), DELTA);
	}
	
	@Test
	public void testLanzarUnCubileteConDosDadosObtieneElValorDeLaSumaDeLosDosDados() {
		Lanzable dado1 = new DadoCubico();
		Lanzable dado2 = new DadoCubico();
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);
		cubilete.lanzar();
		Assert.assertEquals(dado1.obtenerValor() + dado2.obtenerValor(), cubilete.sumarValores(), DELTA);
	}
	
	@Test
	public void testLanzarUnCubileteConTresDadosObtieneElValorDeLaSumaDeLosTresDados() {
		Lanzable dado1 = new DadoCubico();
		Lanzable dado2 = new DadoCubico();
		Lanzable dado3 = new DadoCubico();
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);
		cubilete.agregar(dado3);
		cubilete.lanzar();
		Assert.assertEquals(dado1.obtenerValor() + dado2.obtenerValor() + dado3.obtenerValor(), cubilete.sumarValores(), DELTA);
	}
	

}
