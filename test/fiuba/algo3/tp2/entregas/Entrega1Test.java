package fiuba.algo3.tp2.entregas;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.Comprable;
import fiuba.algo3.tp2.modelo.Cubilete;
import fiuba.algo3.tp2.modelo.DadoCargado;
import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.Encasillable;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.JugadorHumano;
import fiuba.algo3.tp2.modelo.Lanzable;
import fiuba.algo3.tp2.modelo.Tablero;
import fiuba.algo3.tp2.modelo.TableroAlgoPoly;
import fiuba.algo3.tp2.modelo.encasillables.Carcel;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Aysa;
import fiuba.algo3.tp2.modelo.encasillables.comprables.BuenosAiresNorte;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Neuquen;
import fiuba.algo3.tp2.modelo.encasillables.comprables.SantaFe;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.JugadorEnCarcelException;

public class Entrega1Test {

	private Dinero dinero100k = new DineroAlgoPoly(100000);
	private Tablero tablero = new TableroAlgoPoly();
	private Jugador jugador100k = new JugadorHumano(tablero, dinero100k);

	@Test
	public void test01_ElCapitalSeIncrementaEn50000AlCaerEnQuini6PorPrimeraVez() throws Exception {
		Lanzable dado1 = new DadoCargado(7);
		Lanzable dado2 = new DadoCargado(14);
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);
		cubilete.lanzar();
		jugador100k.avanzar(cubilete.sumarValores());
		jugador100k.aplicarEfectoDeCasilleroActual(cubilete);
		int monto_final = jugador100k.obtenerDinero().obtenerMontoEntero();
		int monto_esperado = new DineroAlgoPoly(150000).obtenerMontoEntero();
		Assert.assertEquals(monto_esperado, monto_final);
	}

	@Test
	public void test02_ElCapitalSeIncrementaEn30000AlCaerEnQuini6PorSegundaVez() throws Exception {
		Lanzable dado1 = new DadoCargado(7);
		Lanzable dado2 = new DadoCargado(14);
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);
		cubilete.lanzar();
		jugador100k.avanzar(cubilete.sumarValores());
		jugador100k.aplicarEfectoDeCasilleroActual(cubilete);
		int monto_final = jugador100k.obtenerDinero().obtenerMontoEntero();
		int monto_esperado = new DineroAlgoPoly(150000).obtenerMontoEntero();
		Assert.assertEquals(monto_esperado, monto_final);

		Lanzable dado3 = new DadoCargado(7);
		Lanzable dado4 = new DadoCargado(13);
		Cubilete cubilete2 = new Cubilete();
		cubilete2.agregar(dado3);
		cubilete2.agregar(dado4);
		cubilete2.lanzar();
		jugador100k.avanzar(cubilete2.sumarValores());
		jugador100k.aplicarEfectoDeCasilleroActual(cubilete2);
		monto_final = jugador100k.obtenerDinero().obtenerMontoEntero();
		monto_esperado = new DineroAlgoPoly(180000).obtenerMontoEntero();
		Assert.assertEquals(monto_esperado, monto_final);

	}

	@Test
	public void test03_ElCapitalNoSeIncrementaAlCaerEnQuini6PorTerceraVez() throws Exception {
		Lanzable dado1 = new DadoCargado(7);
		Lanzable dado2 = new DadoCargado(14);
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);
		cubilete.lanzar();
		jugador100k.avanzar(cubilete.sumarValores());
		jugador100k.aplicarEfectoDeCasilleroActual(cubilete);
		int monto_final = jugador100k.obtenerDinero().obtenerMontoEntero();
		int monto_esperado = new DineroAlgoPoly(150000).obtenerMontoEntero();
		Assert.assertEquals(monto_esperado, monto_final);

		Lanzable dado3 = new DadoCargado(7);
		Lanzable dado4 = new DadoCargado(13);
		Cubilete cubilete2 = new Cubilete();
		cubilete2.agregar(dado3);
		cubilete2.agregar(dado4);
		cubilete2.lanzar();
		jugador100k.avanzar(cubilete2.sumarValores());
		jugador100k.aplicarEfectoDeCasilleroActual(cubilete2);
		monto_final = jugador100k.obtenerDinero().obtenerMontoEntero();
		monto_esperado = new DineroAlgoPoly(180000).obtenerMontoEntero();
		Assert.assertEquals(monto_esperado, monto_final);

		Lanzable dado5 = new DadoCargado(7);
		Lanzable dado6 = new DadoCargado(13);
		Cubilete cubilete3 = new Cubilete();
		cubilete3.agregar(dado5);
		cubilete3.agregar(dado6);
		cubilete3.lanzar();
		jugador100k.avanzar(cubilete3.sumarValores());
		jugador100k.aplicarEfectoDeCasilleroActual(cubilete3);
		monto_final = jugador100k.obtenerDinero().obtenerMontoEntero();
		Assert.assertEquals(monto_esperado, monto_final);

	}

	@Test
	public void test04_ElJugadorCompraUnBarrio() throws DineroInsuficienteException {
		Comprable comprable = new BuenosAiresNorte();
		jugador100k.comprar(comprable);
		Assert.assertEquals(comprable.obtenerPropietario(), jugador100k);
	}

	@Test(expected=JugadorEnCarcelException.class)
	public void test05_ElJugadorQueCaeEnLaCarcelNoPuedeMoverse() throws Exception {
		Lanzable dado1 = new DadoCargado(1);
		Lanzable dado2 = new DadoCargado(4);
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);
		cubilete.lanzar();
		jugador100k.avanzar(cubilete.sumarValores());
		jugador100k.aplicarEfectoDeCasilleroActual(cubilete);
		cubilete.lanzar();
		jugador100k.avanzar(cubilete.sumarValores());
	}

	@Test
	public void test06_ElJugadorQuePagaLaFianzaPuedeMoverse() throws Exception {
		Lanzable dado1 = new DadoCargado(1);
		Lanzable dado2 = new DadoCargado(4);
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);
		cubilete.lanzar();
		jugador100k.avanzar(cubilete.sumarValores());
		Encasillable casillero_carcel = jugador100k.obtenerCasilleroActual();
		jugador100k.avanzar(cubilete.sumarValores());
		jugador100k.pagarFianza();
		cubilete.lanzar();
		jugador100k.avanzar(cubilete.sumarValores());
		Encasillable casillero_actual = jugador100k.obtenerCasilleroActual();
		Assert.assertNotEquals(casillero_carcel, casillero_actual);
	}

	@Test(expected=JugadorEnCarcelException.class)
	public void test07_ElJugadorQueNoPuedePagarLaFianzaPorFaltaDeFondosNoPuedeMoverse() throws Exception {
		DineroAlgoPoly dinero40k = new DineroAlgoPoly(40000);
		Jugador jugador40k = new JugadorHumano(tablero,dinero40k);

		Lanzable dado1 = new DadoCargado(2);
		Lanzable dado2 = new DadoCargado(3);
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);
		cubilete.lanzar();
		jugador40k.avanzar(cubilete.sumarValores());
		jugador40k.aplicarEfectoDeCasilleroActual(cubilete);
		try {
			jugador40k.avanzar(cubilete.sumarValores());
		} catch (JugadorEnCarcelException e) {
			// ESTO ES ESPERABLE.
		}
		try {
			jugador40k.pagarFianza();
		} catch (DineroInsuficienteException e) {
			// ESTO ES ESPERABLE.
		}
		cubilete.lanzar();
		jugador40k.avanzar(cubilete.sumarValores());
	}

	@Test
	public void test08_ElJugadorQueCaeEnAvanceDinamicoHabiendoSacado6Avanza4Casilleros() throws JugadorEnCarcelException, DineroInsuficienteException {
		Cubilete cubilete_que_saca_1 = new Cubilete();
		cubilete_que_saca_1.agregar(new DadoCargado(1));
		Cubilete cubilete_que_saca_6 = new Cubilete();
		cubilete_que_saca_6.agregar(new DadoCargado(6));
		cubilete_que_saca_1.lanzar();
		jugador100k.avanzar(cubilete_que_saca_1.sumarValores());
		jugador100k.aplicarEfectoDeCasilleroActual(cubilete_que_saca_1);
		cubilete_que_saca_6.lanzar();
		jugador100k.avanzar(cubilete_que_saca_6.sumarValores());
		jugador100k.aplicarEfectoDeCasilleroActual(cubilete_que_saca_6);
		Encasillable casillero_actual = jugador100k.obtenerCasilleroActual();

		Assert.assertTrue(casillero_actual instanceof SantaFe);
	}

	@Test
	public void test09_ElJugadorQueCaeEnAvanceDinamicoHabiendoSacado7Avanza5CasillerosSiSuCapitalEsDe100000()
			throws JugadorEnCarcelException, DineroInsuficienteException {
		Cubilete cubilete_que_saca_7 = new Cubilete();
		cubilete_que_saca_7.agregar(new DadoCargado(1));
		cubilete_que_saca_7.agregar(new DadoCargado(6));
		cubilete_que_saca_7.lanzar();
		jugador100k.avanzar(cubilete_que_saca_7.sumarValores());
		jugador100k.aplicarEfectoDeCasilleroActual(cubilete_que_saca_7);
		Encasillable casillero_actual = jugador100k.obtenerCasilleroActual();

		Assert.assertTrue(casillero_actual instanceof Aysa);
	}

	@Test
	public void test10_ElJugadorQueCaeEnAvanceDinamicoHabiendoSacado12Avanza10CasillerosSiTiene2Propiedades()
			throws DineroInsuficienteException, JugadorEnCarcelException {

		jugador100k.comprar(new SantaFe());
		jugador100k.comprar(new Neuquen());
		Cubilete cubilete_que_saca_7 = new Cubilete();
		cubilete_que_saca_7.agregar(new DadoCargado(6));
		cubilete_que_saca_7.agregar(new DadoCargado(1));
		Cubilete cubilete_que_saca_12 = new Cubilete();
		cubilete_que_saca_12.agregar(new DadoCargado(6));
		cubilete_que_saca_12.agregar(new DadoCargado(6));
		cubilete_que_saca_7.lanzar();
		cubilete_que_saca_12.lanzar();
		jugador100k.avanzar(cubilete_que_saca_7.sumarValores());
		jugador100k.aplicarEfectoDeCasilleroActual(cubilete_que_saca_12);
		Encasillable casillero_actual = jugador100k.obtenerCasilleroActual();

		Assert.assertTrue(casillero_actual instanceof Neuquen);
	}

	@Test
	public void test11_RetrocesoDinamico() {
		// tests en clase RetrocesoDinamicoTest
		Assert.assertTrue(true);
		;
	}

	@Test
	public void test12_ElJugadorQueCaeEnPoliciaVaALaCarcel()
			throws JugadorEnCarcelException, DineroInsuficienteException {
		Cubilete cubilete_que_saca_15 = new Cubilete();
		cubilete_que_saca_15.agregar(new DadoCargado(15));
		cubilete_que_saca_15.lanzar();
		jugador100k.avanzar(cubilete_que_saca_15.sumarValores());
		jugador100k.aplicarEfectoDeCasilleroActual(cubilete_que_saca_15);
		Encasillable casillero_actual = jugador100k.obtenerCasilleroActual();
		Assert.assertTrue(casillero_actual instanceof Carcel);// <-- REVISAR
	}

	@Test(expected = JugadorEnCarcelException.class)
	public void test12_ElJugadorQueCaeEnPoliciaNoPuedeMoverse() throws Exception {
		Cubilete cubilete_que_saca_15 = new Cubilete();
		cubilete_que_saca_15.agregar(new DadoCargado(15));
		cubilete_que_saca_15.lanzar();
		jugador100k.avanzar(cubilete_que_saca_15.sumarValores());
		jugador100k.aplicarEfectoDeCasilleroActual(cubilete_que_saca_15);
		jugador100k.avanzar(cubilete_que_saca_15.sumarValores());
	}

}