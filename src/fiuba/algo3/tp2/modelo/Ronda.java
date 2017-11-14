package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.excepciones.NoHayJugadoresException;

public abstract class Ronda {
	public abstract void agregarJugador(Jugador jugador);
	public abstract void avanzarTurno();
	public abstract Jugador obtenerJugadorActual() throws NoHayJugadoresException;
}
