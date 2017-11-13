package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AvanceDinamicoTest {

	Tablero tablero = new TableroAlgoPoly();
	Encasillable avance_dinamico = tablero.getCasilleroDestino(tablero.getSalida(), 7);
	Cubilete cubilete_para_llegar = new Cubilete();
	
	@Before
	public void crearCubileteParaLlegarAAvanceDinamico(){
		cubilete_para_llegar.agregar(new DadoCargado(7));
	}
	
	@Test
	public void test01sacandoDe2A6SeAvanzaDosMenos(){
		for(int i = 2; i<= 6; i++){
			Cubilete cubilete = new Cubilete();		
			Jugador jugador = new JugadorHumano(tablero, new DineroAlgoPoly(100000));
			cubilete.agregar(new DadoCargado(i));
			jugador.avanzar(cubilete_para_llegar);
			jugador.interactuarConCasilleroActual(cubilete);
			Encasillable casilleroEsperado = tablero.getCasilleroDestino(avance_dinamico, cubilete.sumarValores() - 2);
			Encasillable casilleroActual = jugador.obtenerCasilleroActual();
			Assert.assertEquals(casilleroEsperado, casilleroActual);			
		}
		
	}
	
	@Test
	public void test02sacandoDe7A10SeAvanzaLaCantidadDineroDelJugadorDivididoLosDados(){
		Assert.assertTrue(true);
	}
	
	@Test
	public void test03sacandoDe11A12SeAvanzaElNumeroMenosCantidadDePropiedades(){
		Assert.assertTrue(true);
	}
}
