package fiuba.algo3.tp2.modelo;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.excepciones.NoHayJugadoresException;
import fiuba.algo3.tp2.modelo.tablero.TableroAlgoPoly;

import org.junit.Assert;

public class RondaAlgoPolyTest {

	@Test
	public void testAgregarJugadorEnUnaRondaVaciaDevuelveElJugadorAgregado() throws NoHayJugadoresException {
		Ronda turnos = new RondaAlgoPoly();
		Jugador jugador = new JugadorHumano(new TableroAlgoPoly(), new DineroAlgoPoly(100));
		turnos.agregarJugador(jugador);
		Assert.assertEquals(jugador, turnos.obtenerJugadorActual());
	}
	
	@Test
	public void testAgregarJugadorEnUnaRondaConUnJugadorDevuelveElPrimerJugador() throws NoHayJugadoresException {
		Ronda turnos = new RondaAlgoPoly();
		Jugador jugador1 = new JugadorHumano(new TableroAlgoPoly(), new DineroAlgoPoly(100));
		Jugador jugador2 = new JugadorHumano(new TableroAlgoPoly(), new DineroAlgoPoly(100));
		turnos.agregarJugador(jugador1);
		turnos.agregarJugador(jugador2);
		Assert.assertEquals(jugador1, turnos.obtenerJugadorActual());
	}

	@Test
	public void testAvanzarUnTurnoEnUnaRondaDeUnJugadorVuelveAlMismoJugador() throws NoHayJugadoresException {
		Ronda turnos = new RondaAlgoPoly();
		Jugador jugador = new JugadorHumano(new TableroAlgoPoly(), new DineroAlgoPoly(100));
		turnos.agregarJugador(jugador);
		turnos.avanzarTurno();
		Assert.assertEquals(jugador, turnos.obtenerJugadorActual());
	}
	
	@Test
	public void testAvanzarUnTurnoEnUnaRondaDeDosJugadoresPasaAlSiguienteJugador() throws NoHayJugadoresException {
		Ronda turnos = new RondaAlgoPoly();
		Jugador jugador1 = new JugadorHumano(new TableroAlgoPoly(), new DineroAlgoPoly(100));
		Jugador jugador2 = new JugadorHumano(new TableroAlgoPoly(), new DineroAlgoPoly(100));
		turnos.agregarJugador(jugador1);
		turnos.agregarJugador(jugador2);
		turnos.avanzarTurno();
		Assert.assertEquals(jugador2, turnos.obtenerJugadorActual());
	}
	
	@Test
	public void testAvanzarDosTurnosEnUnaRondaDeDosJugadoresVuelveAlPrimerJugador() throws NoHayJugadoresException {
		Ronda turnos = new RondaAlgoPoly();
		Jugador jugador1 = new JugadorHumano(new TableroAlgoPoly(), new DineroAlgoPoly(100));
		Jugador jugador2 = new JugadorHumano(new TableroAlgoPoly(), new DineroAlgoPoly(100));
		turnos.agregarJugador(jugador1);
		turnos.agregarJugador(jugador2);
		turnos.avanzarTurno();
		turnos.avanzarTurno();
		Assert.assertEquals(jugador1, turnos.obtenerJugadorActual());
	}

	@Test(expected = NoHayJugadoresException.class)
	public void testRondaAlgoPolyDevuelveJugadorNull() throws NoHayJugadoresException {
		Ronda turnos = new RondaAlgoPoly();
		turnos.obtenerJugadorActual();
	}

}
