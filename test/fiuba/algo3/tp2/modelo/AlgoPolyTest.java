package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.encasillables.Carcel;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Aysa;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Neuquen;
import fiuba.algo3.tp2.modelo.encasillables.comprables.SantaFe;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.JugadorEnCarcelException;

public class AlgoPolyTest {

	private static final double DELTA = 1e-6;

	@Test
	public void test01_ElCapitalSeIncrementaEn50000AlCaerEnQuini6PorPrimeraVez() throws Exception {
		Tablero tablero = new TableroAlgoPoly();
		Ronda ronda = new RondaAlgoPoly();
		ronda.agregarJugador(new JugadorHumano(tablero, new DineroAlgoPoly(100000)));
		Lanzable dado1 = new DadoCargado(7);
		Lanzable dado2 = new DadoCargado(14);
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);
		Jugador jugador = ronda.obtenerJugadorActual();
		cubilete.lanzar();
		jugador.avanzar(cubilete);
		jugador.aplicarEfectoDeCasilleroActual(cubilete);
		double monto_final = jugador.obtenerDinero().obtenerMontoEntero();
		double monto_esperado = new DineroAlgoPoly(150000).obtenerMontoEntero();
		Assert.assertEquals(monto_esperado, monto_final, DELTA);
	}

	@Test
	public void test02_ElCapitalSeIncrementaEn30000AlCaerEnQuini6PorSegundaVez() throws Exception {
		Tablero tablero = new TableroAlgoPoly();
		Ronda ronda = new RondaAlgoPoly();
		ronda.agregarJugador(new JugadorHumano(tablero, new DineroAlgoPoly(100000)));
		Lanzable dado1 = new DadoCargado(7);
		Lanzable dado2 = new DadoCargado(14);
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);
		Jugador jugador = ronda.obtenerJugadorActual();
		cubilete.lanzar();
		jugador.avanzar(cubilete);
		jugador.aplicarEfectoDeCasilleroActual(cubilete);
		double monto_final = jugador.obtenerDinero().obtenerMontoEntero();
		double monto_esperado = new DineroAlgoPoly(150000).obtenerMontoEntero();
		Assert.assertEquals(monto_esperado, monto_final, DELTA);

		Lanzable dado3 = new DadoCargado(7);
		Lanzable dado4 = new DadoCargado(13);
		Cubilete cubilete2 = new Cubilete();
		cubilete2.agregar(dado3);
		cubilete2.agregar(dado4);
		jugador = ronda.obtenerJugadorActual();
		cubilete2.lanzar();
		jugador.avanzar(cubilete2);
		jugador.aplicarEfectoDeCasilleroActual(cubilete2);
		monto_final = jugador.obtenerDinero().obtenerMontoEntero();
		monto_esperado = new DineroAlgoPoly(180000).obtenerMontoEntero();
		Assert.assertEquals(monto_esperado, monto_final, DELTA);

	}

	@Test
	public void test03_ElCapitalNoSeIncrementaAlCaerEnQuini6PorTerceraVez() throws Exception {
		Tablero tablero = new TableroAlgoPoly();
		Ronda ronda = new RondaAlgoPoly();
		ronda.agregarJugador(new JugadorHumano(tablero, new DineroAlgoPoly(100000)));
		Lanzable dado1 = new DadoCargado(7);
		Lanzable dado2 = new DadoCargado(14);
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);
		Jugador jugador = ronda.obtenerJugadorActual();
		cubilete.lanzar();
		jugador.avanzar(cubilete);
		jugador.aplicarEfectoDeCasilleroActual(cubilete);
		double monto_final = jugador.obtenerDinero().obtenerMontoEntero();
		double monto_esperado = new DineroAlgoPoly(150000).obtenerMontoEntero();
		Assert.assertEquals(monto_esperado, monto_final, DELTA);

		Lanzable dado3 = new DadoCargado(7);
		Lanzable dado4 = new DadoCargado(13);
		Cubilete cubilete2 = new Cubilete();
		cubilete2.agregar(dado3);
		cubilete2.agregar(dado4);
		jugador = ronda.obtenerJugadorActual();
		cubilete2.lanzar();
		jugador.avanzar(cubilete2);
		jugador.aplicarEfectoDeCasilleroActual(cubilete2);
		monto_final = jugador.obtenerDinero().obtenerMontoEntero();
		monto_esperado = new DineroAlgoPoly(180000).obtenerMontoEntero();
		Assert.assertEquals(monto_esperado, monto_final, DELTA);

		Lanzable dado5 = new DadoCargado(7);
		Lanzable dado6 = new DadoCargado(13);
		Cubilete cubilete3 = new Cubilete();
		cubilete3.agregar(dado5);
		cubilete3.agregar(dado6);
		jugador = ronda.obtenerJugadorActual();
		cubilete3.lanzar();
		jugador.avanzar(cubilete3);
		jugador.aplicarEfectoDeCasilleroActual(cubilete3);
		monto_final = jugador.obtenerDinero().obtenerMontoEntero();
		Assert.assertEquals(monto_esperado, monto_final, DELTA);

	}

	@Test
	public void test04_ElJugadorCompraUnBarrio() throws Exception {
		Tablero tablero = new TableroAlgoPoly();
		Ronda ronda = new RondaAlgoPoly();
		ronda.agregarJugador(new JugadorHumano(tablero, new DineroAlgoPoly(100000)));
		ronda.agregarJugador(new JugadorHumano(tablero, new DineroAlgoPoly(100000)));
		Lanzable dado1 = new DadoCargado(2);
		Lanzable dado2 = new DadoCargado(2);
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);

		Jugador jugador1 = ronda.obtenerJugadorActual();
		cubilete.lanzar();
		jugador1.avanzar(cubilete);
		jugador1.comprarCasilleroActual();
		ronda.avanzarTurno();
		Jugador jugador2 = ronda.obtenerJugadorActual();
		cubilete.lanzar();
		jugador2.avanzar(cubilete);
		Comprable casillero = (Comprable) jugador2.obtenerCasilleroActual();
		Jugador propietario = casillero.obtenerPropietario();

		Assert.assertEquals(jugador1, propietario);
	}

	@Test
	public void test05_ElJugadorQueCaeEnLaCarcelNoPuedeMoverse() throws Exception {
		Tablero tablero = new TableroAlgoPoly();
		Ronda ronda = new RondaAlgoPoly();
		DineroAlgoPoly dinero_inicial = new DineroAlgoPoly(100000);
		ronda.agregarJugador(new JugadorHumano(tablero, dinero_inicial));
		Lanzable dado1 = new DadoCargado(1);
		Lanzable dado2 = new DadoCargado(4);
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);

		Jugador jugador = ronda.obtenerJugadorActual();
		cubilete.lanzar();
		jugador.avanzar(cubilete);
		jugador.aplicarEfectoDeCasilleroActual(cubilete);
		Encasillable casillero_carcel = jugador.obtenerCasilleroActual();
		ronda.avanzarTurno();
		jugador = ronda.obtenerJugadorActual();
		cubilete.lanzar();
		try {
			jugador.avanzar(cubilete);
		} catch (JugadorEnCarcelException e) {
			//ESTO ES ESPERABLE.
		}
		Encasillable casillero_actual = jugador.obtenerCasilleroActual();

		Assert.assertEquals(casillero_carcel, casillero_actual);
	}

	@Test
	public void test06_ElJugadorQuePagaLaFianzaPuedeMoverse() throws Exception {
		Tablero tablero = new TableroAlgoPoly();
		Ronda ronda = new RondaAlgoPoly();
		DineroAlgoPoly dinero_inicial = new DineroAlgoPoly(100000);
		ronda.agregarJugador(new JugadorHumano(tablero, dinero_inicial));
		Lanzable dado1 = new DadoCargado(1);
		Lanzable dado2 = new DadoCargado(4);
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);

		Jugador jugador = ronda.obtenerJugadorActual();
		cubilete.lanzar();
		jugador.avanzar(cubilete);
		Encasillable casillero_carcel = jugador.obtenerCasilleroActual();
		ronda.avanzarTurno();
		jugador.avanzar(cubilete);
		ronda.avanzarTurno();
		jugador = ronda.obtenerJugadorActual();
		jugador.pagarFianza();
		cubilete.lanzar();
		jugador.avanzar(cubilete);
		Encasillable casillero_actual = jugador.obtenerCasilleroActual();

		Assert.assertNotEquals(casillero_carcel, casillero_actual);
	}

	@Test
	public void test07_ElJugadorQueNoPuedePagarLaFianzaPorFaltaDeFondosNoPuedeMoverse() throws Exception {
		Tablero tablero = new TableroAlgoPoly();
		Ronda ronda = new RondaAlgoPoly();
		DineroAlgoPoly dinero_inicial = new DineroAlgoPoly(40000);
		ronda.agregarJugador(new JugadorHumano(tablero, dinero_inicial));
		Lanzable dado1 = new DadoCargado(2);
		Lanzable dado2 = new DadoCargado(3);
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);

		Jugador jugador = ronda.obtenerJugadorActual();
		cubilete.lanzar();
		jugador.avanzar(cubilete);
		jugador.aplicarEfectoDeCasilleroActual(cubilete);
		Encasillable casillero_carcel = jugador.obtenerCasilleroActual();
		ronda.avanzarTurno();
		try {
			jugador.avanzar(cubilete);
		} catch (JugadorEnCarcelException e) {
			//ESTO ES ESPERABLE.
		}
		ronda.avanzarTurno();
		jugador = ronda.obtenerJugadorActual();
		try {
			jugador.pagarFianza();
		} catch(DineroInsuficienteException e) {};
		cubilete.lanzar();
		try {
			jugador.avanzar(cubilete);
		} catch (JugadorEnCarcelException e) {
			//ESTO ES ESPERABLE.
		}
		jugador.aplicarEfectoDeCasilleroActual(cubilete);
		Encasillable casillero_actual = jugador.obtenerCasilleroActual();

		Assert.assertEquals(casillero_carcel, casillero_actual);

	}

	@Test
	public void test08_ElJugadorQueCaeEnAvanceDinamicoHabiendoSacado6Avanza4Casilleros() throws Exception {
		Tablero tablero = new TableroAlgoPoly();
		Ronda ronda = new RondaAlgoPoly();
		ronda.agregarJugador(new JugadorHumano(tablero, new DineroAlgoPoly(100000)));
		Cubilete cubilete_que_saca_1 = new Cubilete();
		cubilete_que_saca_1.agregar(new DadoCargado(1));
		Cubilete cubilete_que_saca_6 = new Cubilete();
		cubilete_que_saca_6.agregar(new DadoCargado(6));

		Jugador jugador = ronda.obtenerJugadorActual();
		cubilete_que_saca_1.lanzar();
		jugador.avanzar(cubilete_que_saca_1);
		jugador.aplicarEfectoDeCasilleroActual(cubilete_que_saca_1);
		ronda.avanzarTurno();
		jugador = ronda.obtenerJugadorActual();
		cubilete_que_saca_6.lanzar();
		jugador.avanzar(cubilete_que_saca_6);
		jugador.aplicarEfectoDeCasilleroActual(cubilete_que_saca_6);
		Encasillable casillero_actual = jugador.obtenerCasilleroActual();

		Assert.assertTrue(casillero_actual instanceof SantaFe);// <-- REVISAR
	}

	@Test
	public void test09_ElJugadorQueCaeEnAvanceDinamicoHabiendoSacado7Avanza5CasillerosSiSuCapitalEsDe100000() throws Exception {
		Tablero tablero = new TableroAlgoPoly();
		Ronda ronda = new RondaAlgoPoly();
		ronda.agregarJugador(new JugadorHumano(tablero, new DineroAlgoPoly(100000)));
		Cubilete cubilete_que_saca_7 = new Cubilete();
		cubilete_que_saca_7.agregar(new DadoCargado(1));
		cubilete_que_saca_7.agregar(new DadoCargado(6));

		Jugador jugador = ronda.obtenerJugadorActual();
		cubilete_que_saca_7.lanzar();
		jugador.avanzar(cubilete_que_saca_7);
		jugador.aplicarEfectoDeCasilleroActual(cubilete_que_saca_7);
		Encasillable casillero_actual = jugador.obtenerCasilleroActual();

		Assert.assertTrue(casillero_actual instanceof Aysa);
	}

	@Test
	public void test10_ElJugadorQueCaeEnAvanceDinamicoHabiendoSacado12Avanza10CasillerosSiTiene2Propiedades() throws Exception {
		Tablero tablero = new TableroAlgoPoly();
		Ronda ronda = new RondaAlgoPoly();
		Jugador jugador = new JugadorHumano(tablero, new DineroAlgoPoly(100000));
		jugador.agregarPropiedad(new SantaFe());
		jugador.agregarPropiedad(new Neuquen());
		ronda.agregarJugador(jugador);
		Cubilete cubilete_que_saca_7 = new Cubilete();
		cubilete_que_saca_7.agregar(new DadoCargado(6));
		cubilete_que_saca_7.agregar(new DadoCargado(1));
		Cubilete cubilete_que_saca_12 = new Cubilete();
		cubilete_que_saca_12.agregar(new DadoCargado(6));
		cubilete_que_saca_12.agregar(new DadoCargado(6));

		jugador = ronda.obtenerJugadorActual();
		cubilete_que_saca_7.lanzar();
		cubilete_que_saca_12.lanzar();
		jugador.avanzar(cubilete_que_saca_7);
		jugador.aplicarEfectoDeCasilleroActual(cubilete_que_saca_12);
		Encasillable casillero_actual = jugador.obtenerCasilleroActual();

		Assert.assertTrue(casillero_actual instanceof Neuquen);
	}

	@Test
	public void test11_RetrocesoDinamico() {
		// tests en clase RetrocesoDinamicoTest
		Assert.assertTrue(true);
		;
	}

	@Test
	public void test12_ElJugadorQueCaeEnPoliciaVaALaCarcel() throws Exception {
		Tablero tablero = new TableroAlgoPoly();
		Ronda ronda = new RondaAlgoPoly();
		ronda.agregarJugador(new JugadorHumano(tablero, new DineroAlgoPoly(100000)));
		Cubilete cubilete_que_saca_15 = new Cubilete();
		cubilete_que_saca_15.agregar(new DadoCargado(15));

		Jugador jugador = ronda.obtenerJugadorActual();
		cubilete_que_saca_15.lanzar();
		jugador.avanzar(cubilete_que_saca_15);
		jugador.aplicarEfectoDeCasilleroActual(cubilete_que_saca_15);
		Encasillable casillero_actual = jugador.obtenerCasilleroActual();

		Assert.assertTrue(casillero_actual instanceof Carcel);// <-- REVISAR
	}

	@Test
	public void test12_ElJugadorQueCaeEnPoliciaNoPuedeMoverse() throws Exception {
		Tablero tablero = new TableroAlgoPoly();
		Ronda ronda = new RondaAlgoPoly();
		ronda.agregarJugador(new JugadorHumano(tablero, new DineroAlgoPoly(100000)));
		Cubilete cubilete_que_saca_15 = new Cubilete();
		cubilete_que_saca_15.agregar(new DadoCargado(15));

		Jugador jugador = ronda.obtenerJugadorActual();
		cubilete_que_saca_15.lanzar();
		jugador.avanzar(cubilete_que_saca_15);
		jugador.aplicarEfectoDeCasilleroActual(cubilete_que_saca_15);
		Encasillable casillero_esperado = jugador.obtenerCasilleroActual();
		try {
			jugador.avanzar(cubilete_que_saca_15);
		} catch (JugadorEnCarcelException e) {
			//ESTO ES ESPERABLE.
		}
		Encasillable casillero_actual = jugador.obtenerCasilleroActual();

		Assert.assertEquals(casillero_esperado, casillero_actual);
	}

}
