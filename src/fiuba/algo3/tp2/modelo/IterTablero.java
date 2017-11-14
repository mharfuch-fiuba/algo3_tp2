package fiuba.algo3.tp2.modelo;

/*
public class IterTablero{

	DoublyLinkedCircularListIterator iterador;

	public IterTablero(DoublyLinkedCircularListIterator iterador_tablero) {
		iterador = iterador_tablero;
	}

	public Encasillable avanzar() {
		return (Encasillable) iterador.next();
	}

	public Encasillable retroceder() {
		return (Encasillable) iterador.prev();
	}

	public Encasillable verActual() {
		return (Encasillable) iterador.actual();
	}

	public void avanzarHasta(Encasillable casillero_destino) {
		for(int i = 0; i < iterador.size(); i++) {
			if(iterador.actual() == casillero_destino) return;
			iterador.next();
		}
	}
}

*/

public interface IterTablero{
	public Encasillable avanzar();
	public Encasillable retroceder();
	public Encasillable verActual();
	public void avanzarHasta(Encasillable casillero_destino);
}
