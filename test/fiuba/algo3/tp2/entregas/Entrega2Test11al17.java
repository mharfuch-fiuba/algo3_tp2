package fiuba.algo3.tp2.entregas;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.Cubilete;
import fiuba.algo3.tp2.modelo.DadoCargado;
import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.JugadorHumano;
import fiuba.algo3.tp2.modelo.Tablero;
import fiuba.algo3.tp2.modelo.TableroAlgoPoly;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.JugadorEnCarcelException;

public class Entrega2Test11al17 {

	private Tablero tablero = new TableroAlgoPoly();

	@Test
	public void test11_jugadorSacaDoceCaeEnTrenYaAdquiridoSuPropietarioNoTieneSubteSuDineroSeReduce5400() throws JugadorEnCarcelException, DineroInsuficienteException {
		final int monto_inicial = 20000;
		final int monto_esperado = monto_inicial - 5400;
		Cubilete cubilete_que_saca_12 = new Cubilete();
		cubilete_que_saca_12.agregar(new DadoCargado(12));
		Cubilete cubilete_que_saca_16 = new Cubilete();
		cubilete_que_saca_16.agregar(new DadoCargado(16));
		/* CREO AL JUGADOR 1, LO AVANZO HASTA EL TREN Y LO COMPRO */
		Jugador jugador1 = new JugadorHumano(tablero, new DineroAlgoPoly(100000));
		jugador1.avanzar(cubilete_que_saca_16.sumarValores());
		jugador1.comprarCasilleroActual();
		/* CREO AL JUGADOR 2 Y LO AVANZO HASTA EL TREN */
		Jugador jugador2 = new JugadorHumano(tablero, new DineroAlgoPoly(monto_inicial));
		jugador2.avanzar(cubilete_que_saca_16.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(cubilete_que_saca_12); // EMULA HABER SACADO 12
		Assert.assertEquals(monto_esperado, jugador2.obtenerDinero().obtenerMontoEntero());
	}

	@Test
	public void test12_jugadorSacaDoceCaeEnTrenYaAdquiridoSuPropietarioTieneSubteSuDineroSeReduce9600() throws JugadorEnCarcelException, DineroInsuficienteException {
		final int monto_inicial = 20000;
		final int monto_esperado = monto_inicial - 9600;
		
		Cubilete cubilete_que_saca_12 = new Cubilete();
		cubilete_que_saca_12.agregar(new DadoCargado(12));
		/* CREO AL JUGADOR 1, LO AVANZO HASTA EL SUBTE Y LO COMPRO LUEGO HASTA EL TREN Y LO COMPRO */
		Cubilete cubilete_que_saca_8 = new Cubilete();
		cubilete_que_saca_8.agregar(new DadoCargado(8));
		Jugador jugador1 = new JugadorHumano(tablero, new DineroAlgoPoly(100000));
		jugador1.avanzar(cubilete_que_saca_8.sumarValores());
		//POR QUE NO UN METODO: COMPRAR CASILLERO ACTUAL?
		jugador1.comprarCasilleroActual(); // Compra el subte
		jugador1.avanzar(cubilete_que_saca_8.sumarValores());
		jugador1.comprarCasilleroActual(); // Compra el tren
		/* CREO AL JUGADOR 2 Y LO AVANZO HASTA EL TREN */
		Cubilete cubilete_que_saca_16 = new Cubilete();
		cubilete_que_saca_16.agregar(new DadoCargado(16));
		Jugador jugador2 = new JugadorHumano(tablero, new DineroAlgoPoly(monto_inicial));
		jugador2.avanzar(cubilete_que_saca_16.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(cubilete_que_saca_12); // EMULA HABER SACADO 12
		Assert.assertEquals(monto_esperado, jugador2.obtenerDinero().obtenerMontoEntero());
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
	public void test15_JugadorCaeEnImpuestoAlLujoYSuDineroDisminuye10Porciento() throws JugadorEnCarcelException, DineroInsuficienteException {
		final int monto_inicial = 10000;
		final int monto_esperado = monto_inicial - (int) (monto_inicial * 0.1);
		
		Cubilete cubilete_que_saca_10 = new Cubilete();
		cubilete_que_saca_10.agregar(new DadoCargado(10));
		/* CREO AL JUGADOR 1, LO AVANZO HASTA EDESUR Y LO COMPRO */
		Jugador jugador1 = new JugadorHumano(tablero, new DineroAlgoPoly(monto_inicial));
		jugador1.avanzar(cubilete_que_saca_10.sumarValores());
		jugador1.aplicarEfectoDeCasilleroActual(cubilete_que_saca_10);
		Assert.assertEquals(monto_esperado, jugador1.obtenerDinero().obtenerMontoEntero());
	}

	@Test
	public void test16_jugadorSacaDoceCaeEnEdesurYaAdquiridoSuPropietarioNoTieneAyseSuDineroSeReduce6000() throws JugadorEnCarcelException, DineroInsuficienteException {
		final int monto_inicial = 20000;
		final int monto_esperado = monto_inicial - 6000;
		
		Cubilete cubilete_que_saca_12 = new Cubilete();
		cubilete_que_saca_12.agregar(new DadoCargado(12));
		Cubilete cubilete_que_saca_3 = new Cubilete();
		cubilete_que_saca_3.agregar(new DadoCargado(3));
		/* CREO AL JUGADOR 1, LO AVANZO HASTA EDESUR Y LO COMPRO */
		Jugador jugador1 = new JugadorHumano(tablero, new DineroAlgoPoly(100000));
		jugador1.avanzar(cubilete_que_saca_3.sumarValores());
		jugador1.comprarCasilleroActual();
		/* CREO AL JUGADOR 2 Y LO AVANZO HASTA EDESUR */
		Jugador jugador2 = new JugadorHumano(tablero, new DineroAlgoPoly(monto_inicial));
		jugador2.avanzar(cubilete_que_saca_3.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(cubilete_que_saca_12); // EMULA HABER SACADO 12
		Assert.assertEquals(monto_esperado, jugador2.obtenerDinero().obtenerMontoEntero());
	}

	@Test
	public void test17_jugadorSacaDoceCaeEnEdesurYaAdquiridoSuPropietarioTieneAysaSuDineroSeReduce12000() throws JugadorEnCarcelException, DineroInsuficienteException {
		final int monto_inicial = 20000;
		final int monto_esperado = monto_inicial - 12000;
		
		Cubilete cubilete_que_saca_12 = new Cubilete();
		cubilete_que_saca_12.agregar(new DadoCargado(12));
		/* CREO AL JUGADOR 1, LO AVANZO HASTA EDESUR Y LO COMPRO LUEGO HASTA AYSA Y LO COMPRO */
		Cubilete cubilete_que_saca_3 = new Cubilete();
		cubilete_que_saca_3.agregar(new DadoCargado(3));
		Jugador jugador1 = new JugadorHumano(tablero, new DineroAlgoPoly(100000));
		jugador1.avanzar(cubilete_que_saca_3.sumarValores());
		jugador1.comprarCasilleroActual(); // Compra edesur
		Cubilete cubilete_que_saca_9 = new Cubilete();
		cubilete_que_saca_9.agregar(new DadoCargado(9));
		jugador1.avanzar(cubilete_que_saca_9.sumarValores());
		jugador1.comprarCasilleroActual(); // Compra aysa
		/* CREO AL JUGADOR 2 Y LO AVANZO HASTA EDESUR */
		Jugador jugador2 = new JugadorHumano(tablero, new DineroAlgoPoly(monto_inicial));
		jugador2.avanzar(cubilete_que_saca_3.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(cubilete_que_saca_12); // EMULA HABER SACADO 12
		Assert.assertEquals(monto_esperado, jugador2.obtenerDinero().obtenerMontoEntero());
	}

}
