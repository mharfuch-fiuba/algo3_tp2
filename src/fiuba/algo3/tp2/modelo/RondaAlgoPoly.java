package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class RondaAlgoPoly extends Ronda{
	
	private ArrayList<Jugador> jugadores;
	private int turno_numero;
	
	public RondaAlgoPoly() {
		jugadores = new ArrayList<Jugador>();
		turno_numero = 0;
	}
	
	public void agregarJugador(Jugador jugador) {
		jugadores.add(jugador);
		jugador.agregarNombre(jugadores.indexOf(jugador));
	}
	
	public void avanzarTurno() {
		turno_numero++;
	}
	
	public int obtenerUbicacion(Jugador jugador){
		return jugadores.indexOf(jugador);
		
	}
	
	public Jugador obtenerJugadorActual() {
		try {
			return jugadores.get(turno_numero);
		} catch (IndexOutOfBoundsException e) {
			turno_numero = 0;
			return jugadores.get(turno_numero);
		}
	}
	
	
	
}
