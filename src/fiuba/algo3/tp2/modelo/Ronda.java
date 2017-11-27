package fiuba.algo3.tp2.modelo;

import java.util.Observable;

import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.excepciones.NoHayJugadoresException;

public abstract class Ronda extends Observable implements Iterable<Jugador>{
	
	public abstract void agregarJugador(Jugador jugador);
	public abstract void avanzarTurno() throws NoHayJugadoresException;
	public abstract Jugador obtenerJugadorActual() throws NoHayJugadoresException;
	public abstract Cubilete getCubilete();
}
