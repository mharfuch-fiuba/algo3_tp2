package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.excepciones.NoHayJugadoresException;

public abstract class Ronda implements Iterable<Jugador>{
	
	public abstract void agregarJugador(Jugador jugador);
	public abstract void avanzarTurno() throws NoHayJugadoresException;
	public abstract Jugador obtenerJugadorActual() throws NoHayJugadoresException;
	
}
