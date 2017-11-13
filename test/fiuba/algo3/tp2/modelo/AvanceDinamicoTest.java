package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.encasillables.comprables.Neuquen;

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
		int cantidad_random = (int)Math.random() * 1000000;
		for(int i = 7; i<=10; i++){
			Cubilete cubilete = new Cubilete();
			Jugador jugador = new JugadorHumano(tablero, new DineroAlgoPoly(cantidad_random));
			cubilete.agregar(new DadoCargado(i));
			jugador.avanzar(cubilete_para_llegar);
			jugador.interactuarConCasilleroActual(cubilete);
			Encasillable casilleroEsperado = tablero.getCasilleroDestino(avance_dinamico, jugador.obtenerDinero().obtenerMontoEntero() % cubilete.sumarValores());
			Encasillable casilleroActual = jugador.obtenerCasilleroActual();
			Assert.assertEquals(casilleroEsperado, casilleroActual);
		}
		Assert.assertTrue(true);
	}
	
	@Test
	public void test03sacandoDe11A12SeAvanzaElNumeroMenosCantidadDePropiedades(){
		int propiedades_random = (int)Math.random() * 10;
		ArrayList<Comprable> propiedades = new ArrayList<Comprable>();
		for(int i=1; i<=propiedades_random; i++){
			propiedades.add(new Neuquen());
		}
		for(int i=11; i<=12;i++){
			Cubilete cubilete = new Cubilete();
			Jugador jugador = new JugadorHumano(tablero, new DineroAlgoPoly(100000),new ArrayList<Comprable>());
			cubilete.agregar(new DadoCargado(i));
			jugador.avanzar(cubilete_para_llegar);
			jugador.interactuarConCasilleroActual(cubilete);
			Encasillable casilleroEsperado = tablero.getCasilleroDestino(avance_dinamico, cubilete.sumarValores() - jugador.getCantidadDePropiedades());
			Encasillable casilleroActual = jugador.obtenerCasilleroActual();
			Assert.assertEquals(casilleroEsperado, casilleroActual);
		}
	}
}
