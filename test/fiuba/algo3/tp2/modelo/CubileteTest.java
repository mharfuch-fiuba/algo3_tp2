package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.cubilete.CubileteFalso;
import fiuba.algo3.tp2.modelo.cubilete.DadoCargado;
import fiuba.algo3.tp2.modelo.cubilete.DadoCubico;
import fiuba.algo3.tp2.modelo.cubilete.Lanzable;

public class CubileteTest {
	
	private static final double DELTA = 1e-6;
	
	@Test
	public void testCubileteFalsoSeComportaIgualQueCubilete(){
		Cubilete cubilete = Cubilete.getInstance();
		CubileteFalso cubilete_falso = new CubileteFalso();
		
		Lanzable dado_cargado = new DadoCargado(4);
		
		cubilete.agregar(dado_cargado);
		cubilete_falso.agregar(dado_cargado);
		
		cubilete.lanzar();
		cubilete_falso.lanzar();
		
		int uno = cubilete.sumarValores();
		int dos = cubilete_falso.sumarValores();
		Assert.assertTrue(cubilete.sumarValores() == cubilete_falso.sumarValores());
	}
	
	//TESTEO PATRON SINGLETON DE CUBILETE
	
	@Test
	public void testCubileteGetInstanceSiempreDevuelveCubileteCreado(){
		Assert.assertNotEquals(null, Cubilete.getInstance());
	}
	
	@Test
	public void testLaInstanciaSiempreEsLaMisma(){
		Cubilete cubilete1 = Cubilete.getInstance();
		Cubilete cubilete2 = Cubilete.getInstance();
		Assert.assertEquals(cubilete1, cubilete2);
	}
	
	@Test
	public void testSiLanzoElDadoSeLanzaEnAmbasInstancias(){
		Cubilete cubilete1 = Cubilete.getInstance();
		Cubilete cubilete2 = Cubilete.getInstance();
		cubilete1.lanzar();
		Assert.assertEquals(cubilete1.sumarValores(), cubilete2.sumarValores());
	}
	
	
	//TESTEAMOS EL CUBILETE FALSO QUE SE COMPORTA EXACTAMENTE IGUAL QUE EL REAL, PERO SE PUEDE INSTANCIAR UNO NUEVO VACIO
	
	@Test
	public void testCubileteFalso() {
		CubileteFalso cubilete = new CubileteFalso();
		Assert.assertNotEquals(null, cubilete);
	}

	@Test
	public void testLanzarUnCubileteFalsoSinDadosObtiene0() {
		//TAL VEZ DEBERIA LANZAR UNA EXCEPCION
		CubileteFalso cubilete = new CubileteFalso();
		cubilete.lanzar();
		Assert.assertEquals(0, cubilete.sumarValores(), DELTA);
	}
	
	@Test
	public void testLanzarUnCubileteFalsoConUnDadoObtieneElValorDelDado() {
		Lanzable dado = new DadoCubico();
		CubileteFalso cubilete = new CubileteFalso();
		cubilete.agregar(dado);
		cubilete.lanzar();
		Assert.assertEquals(dado.obtenerValor(), cubilete.sumarValores(), DELTA);
	}
	
	@Test
	public void testLanzarUnCubileteFalsoConDosDadosObtieneElValorDeLaSumaDeLosDosDados() {
		Lanzable dado1 = new DadoCubico();
		Lanzable dado2 = new DadoCubico();
		CubileteFalso cubilete = new CubileteFalso();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);
		cubilete.lanzar();
		Assert.assertEquals(dado1.obtenerValor() + dado2.obtenerValor(), cubilete.sumarValores(), DELTA);
	}
	
	@Test
	public void testLanzarUnCubileteFalsoConTresDadosObtieneElValorDeLaSumaDeLosTresDados() {
		Lanzable dado1 = new DadoCubico();
		Lanzable dado2 = new DadoCubico();
		Lanzable dado3 = new DadoCubico();
		CubileteFalso cubilete = new CubileteFalso();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);
		cubilete.agregar(dado3);
		cubilete.lanzar();
		Assert.assertEquals(dado1.obtenerValor() + dado2.obtenerValor() + dado3.obtenerValor(), cubilete.sumarValores(), DELTA);
	}
	

}
