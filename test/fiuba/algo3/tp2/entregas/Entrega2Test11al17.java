package fiuba.algo3.tp2.entregas;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.Comprable;
import fiuba.algo3.tp2.modelo.Cubilete;
import fiuba.algo3.tp2.modelo.DadoCargado;
import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.JugadorHumano;
import fiuba.algo3.tp2.modelo.Lanzable;
import fiuba.algo3.tp2.modelo.Tablero;
import fiuba.algo3.tp2.modelo.TableroAlgoPoly;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.JugadorEnCarcelException;

public class Entrega2Test11al17 {

	private Tablero tablero = new TableroAlgoPoly();

	@Test
	public void test11_jugadorSacaDoceCaeEnTrenYaAdquiridoSuPropietarioNoTieneSubteSuDineroSeReduce5400() throws JugadorEnCarcelException, DineroInsuficienteException {
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(new DadoCargado(16));
		/* CREO AL JUGADOR 1, LO AVANZO HASTA EL TREN Y LO COMPRO */
		Jugador jugador1 = new JugadorHumano(tablero, new DineroAlgoPoly(10000));
		jugador1.avanzar(cubilete.sumarValores());
		jugador1.comprarCasilleroActual();
		/* CREO AL JUGADOR 2 Y LO AVANZO HASTA EL TREN */
		Jugador jugador2 = new JugadorHumano(tablero, new DineroAlgoPoly(10000));
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(cubilete);
		Assert.assertEquals(4600, jugador2.obtenerDinero().obtenerMontoEntero());
	}

	@Test
	public void test12_jugadorSacaDoceCaeEnTrenYaAdquiridoSuPropietarioTieneSubteSuDineroSeReduce9600() throws JugadorEnCarcelException, DineroInsuficienteException {
		/* CREO AL JUGADOR 1, LO AVANZO HASTA EL SUBTE Y LO COMPRO LUEGO HASTA EL TREN Y LO COMPRO */
		Cubilete cubilete_que_saca_8 = new Cubilete();
		cubilete_que_saca_8.agregar(new DadoCargado(8));
		Jugador jugador1 = new JugadorHumano(tablero, new DineroAlgoPoly(10000));
		jugador1.avanzar(cubilete_que_saca_8.sumarValores());
		//POR QUE NO UN METODO: COMPRAR CASILLERO ACTUAL?
		jugador1.comprarCasilleroActual(); // Compra el subte
		jugador1.avanzar(cubilete_que_saca_8.sumarValores());
		jugador1.comprarCasilleroActual(); // Compra el tren
		/* CREO AL JUGADOR 2 Y LO AVANZO HASTA EL TREN */
		Cubilete cubilete_que_saca_16 = new Cubilete();
		cubilete_que_saca_16.agregar(new DadoCargado(16));
		Jugador jugador2 = new JugadorHumano(tablero, new DineroAlgoPoly(10000));
		jugador2.avanzar(cubilete_que_saca_16.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(cubilete_que_saca_16);
		Assert.assertEquals(400, jugador2.obtenerDinero().obtenerMontoEntero());
	}

	@Test
	public void test13_() {
		fail();
	}

	@Test
	public void test14_() {
		fail();
	}

	@Test
	public void test15_JugadorCaeEnImpuestoAlLujoYSuDineroDisminuye10Porciento() {
	/*
			throws JugadorEnCarcelException, DineroInsuficienteException {
		Cubilete cubilete = new Cubilete();
		Lanzable dadoSiempre10 = new DadoCargado(10);
		cubilete.agregar(dadoSiempre10);
		jugador100k.avanzar(10);
		jugador100k.aplicarEfectoDeCasilleroActual(cubilete);
		Assert.assertEquals(90000, jugador100k.obtenerDinero().obtenerMontoEntero());
		*/
	}

	@Test
	public void test16_() {
		fail();
	}

	@Test
	public void test17_() {
		fail();
	}

}
