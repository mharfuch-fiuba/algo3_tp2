package fiuba.algo3.tp2.modelo;

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
		this.iterador.next();
	}

	@Override
	public Jugador obtenerJugadorActual() throws NoHayJugadoresException {
		try {
			return (Jugador) this.iterador.actual();// puedo porque se que guardo solo Jugadores
		} catch (Exception e) {
			throw new NoHayJugadoresException();
		}
	}
	
	

}
