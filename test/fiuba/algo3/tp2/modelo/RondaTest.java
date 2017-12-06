package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.excepciones.NoHayJugadoresException;
import fiuba.algo3.tp2.modelo.tablero.Tablero;

public class RondaTest {

	@Test
	public void testAgregarJugadorEnUnaRondaVaciaDevuelveElJugadorAgregado() throws NoHayJugadoresException {
		Ronda turnos = new Ronda();
		Jugador jugador = new JugadorHumano(new Tablero(), new Dinero(100));
		turnos.agregarJugador(jugador);
		Assert.assertEquals(jugador, turnos.obtenerJugadorActual());
	}
	
	@Test
	public void testAgregarJugadorEnUnaRondaConUnJugadorDevuelveElPrimerJugador() throws NoHayJugadoresException {
		Ronda turnos = new Ronda();
		Jugador jugador1 = new JugadorHumano(new Tablero(), new Dinero(100));
		Jugador jugador2 = new JugadorHumano(new Tablero(), new Dinero(100));
		turnos.agregarJugador(jugador1);
		turnos.agregarJugador(jugador2);
		Assert.assertEquals(jugador1, turnos.obtenerJugadorActual());
	}

	@Test
	public void testAvanzarUnTurnoEnUnaRondaDeUnJugadorVuelveAlMismoJugador() throws NoHayJugadoresException {
		Ronda turnos = new Ronda();
		Jugador jugador = new JugadorHumano(new Tablero(), new Dinero(100));
		turnos.agregarJugador(jugador);
		turnos.avanzarTurno();
		Assert.assertEquals(jugador, turnos.obtenerJugadorActual());
	}
	
	@Test
	public void testAvanzarUnTurnoEnUnaRondaDeDosJugadoresPasaAlSiguienteJugador() throws NoHayJugadoresException {
		Ronda turnos = new Ronda();
		Jugador jugador1 = new JugadorHumano(new Tablero(), new Dinero(100));
		Jugador jugador2 = new JugadorHumano(new Tablero(), new Dinero(100));
		turnos.agregarJugador(jugador1);
		turnos.agregarJugador(jugador2);
		turnos.avanzarTurno();
		Assert.assertEquals(jugador2, turnos.obtenerJugadorActual());
	}
	
	@Test
	public void testAvanzarDosTurnosEnUnaRondaDeDosJugadoresVuelveAlPrimerJugador() throws NoHayJugadoresException {
		Ronda turnos = new Ronda();
		Jugador jugador1 = new JugadorHumano(new Tablero(), new Dinero(100));
		Jugador jugador2 = new JugadorHumano(new Tablero(), new Dinero(100));
		turnos.agregarJugador(jugador1);
		turnos.agregarJugador(jugador2);
		turnos.avanzarTurno();
		turnos.avanzarTurno();
		Assert.assertEquals(jugador1, turnos.obtenerJugadorActual());
	}

	@Test(expected = NoHayJugadoresException.class)
	public void testRondaAlgoPolyDevuelveJugadorNull() throws NoHayJugadoresException {
		Ronda turnos = new Ronda();
		turnos.obtenerJugadorActual();
	}
	
	@Test
	public void testRondaEsIterable() throws NoHayJugadoresException {
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		Ronda turnos = new Ronda();
		Jugador jugador1 = new JugadorHumano(new Tablero(), new Dinero(100));
		Jugador jugador2 = new JugadorHumano(new Tablero(), new Dinero(100));
		Jugador jugador3 = new JugadorHumano(new Tablero(), new Dinero(100));
		turnos.agregarJugador(jugador1);
		jugadores.add(jugador1);
		turnos.agregarJugador(jugador2);
		jugadores.add(jugador2);
		turnos.agregarJugador(jugador3);
		jugadores.add(jugador3);
		int i = 0;
		for(Jugador jugador:turnos) {
			Assert.assertEquals(jugadores.get(i), jugador);
			i++;
		}
	}

}
