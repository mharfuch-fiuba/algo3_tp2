package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

import fiuba.algo3.tp2.modelo.excepciones.NoHayJugadoresException;

public class RondaAlgoPoly extends Ronda{
	
	private ArrayList<Jugador> jugadores;
	private int turno_numero;
	
	public RondaAlgoPoly() {
		jugadores = new ArrayList<Jugador>();
		turno_numero = 0;
	}
	
	public void agregarJugador(Jugador jugador) {
		jugadores.add(jugador);
	}
	
	public void avanzarTurno() throws NoHayJugadoresException {
		Jugador jugador = this.obtenerJugadorActual();
		jugador.disminuirDiasDeCarcel();
		turno_numero++;
	}
		
	public Jugador obtenerJugadorActual() throws NoHayJugadoresException {
		try {
			return jugadores.get(turno_numero);
		} catch (IndexOutOfBoundsException e) {
			turno_numero = 0;
			try {
				return jugadores.get(turno_numero);
			} catch (IndexOutOfBoundsException f) {
				throw new NoHayJugadoresException();
			}
		}
	}
	
	
	
}
