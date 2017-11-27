package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Iterator;

import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.excepciones.NoHayJugadoresException;
import fiuba.algo3.tp2.utils.DoublyLinkedCircularList;
import fiuba.algo3.tp2.utils.DoublyLinkedCircularListIterator;

public class RondaAlgoPoly extends Ronda {

	private DoublyLinkedCircularList datos;
	private DoublyLinkedCircularListIterator iterador;

	public RondaAlgoPoly() {
		this.datos = new DoublyLinkedCircularList();
		this.iterador = this.datos.iterator();
	}

	@Override
	public void agregarJugador(Jugador jugador) {
		// Puede cambiar el jugador actual!
		datos.add(jugador);
		this.iterador = datos.iterator();
	}

	@Override
	public void avanzarTurno() throws NoHayJugadoresException {
		Jugador actual = (Jugador) iterador.actual();
		actual.avisarCambioDeTurno();
		iterador.next();
		setChanged();
		notifyObservers();
	}

	@Override
	public Jugador obtenerJugadorActual() throws NoHayJugadoresException {
		try {
			return (Jugador) this.iterador.actual();// puedo porque se que guardo solo Jugadores
		} catch (Exception e) {
			throw new NoHayJugadoresException();
		}
	}
	
	private ArrayList<Jugador> obtenerJugadores(){
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		for(int i = 0; i < iterador.size(); i++) {
			jugadores.add((Jugador)iterador.actual());
			iterador.next();
		}
		return jugadores;
	}

	@Override
	public Iterator<Jugador> iterator() {
		return obtenerJugadores().iterator();
	}

	@Override
	public Cubilete getCubilete() {
		// TODO Auto-generated method stub
		return new Cubilete();
	}
	
	

}
