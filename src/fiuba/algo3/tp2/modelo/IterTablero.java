package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.utils.DoublyLinkedCircularList.DoublyLinkedCircularListIterator;

public class IterTablero{

//	private ArrayList<Encasillable> casilleros;
//	private int pos_actual;
	DoublyLinkedCircularListIterator iterador;
/*
	public IterTablero(TableroAlgoPoly tablero) {
		this.casilleros = tablero.obtenerListaCasilleros();
		this.pos_actual = 0;
	}
*/
	public IterTablero(DoublyLinkedCircularListIterator iterador_tablero) {
		iterador = iterador_tablero;
	}
/*
	public Encasillable avanzar() {
		pos_actual++;
		try {
			return this.verActual();
		}catch (IndexOutOfBoundsException e) {
			pos_actual = 0;
			return this.verActual();
		}
	}
*/	
	public Encasillable avanzar() {
		return (Encasillable) iterador.next();
	}
/*	
	public Encasillable retroceder() {
		pos_actual--;
		try {
			return this.verActual();
		}catch (IndexOutOfBoundsException e) {
			pos_actual = 0;
			return this.verActual();
		}
	}
*/
	public Encasillable retroceder() {
		return (Encasillable) iterador.prev();
	}
/*	
	public Encasillable verActual() {
		return casilleros.get(pos_actual);
	}
*/
	public Encasillable verActual() {
		return (Encasillable) iterador.actual();
	}
/*	
	public void avanzarHasta(Encasillable casillero_destino) {
		int i = 0;
		for(Encasillable casillero_actual:casilleros) {
			if(casillero_actual == casillero_destino) {
				pos_actual = i;
			}
			i++;
		}
	}
*/
	public void avanzarHasta(Encasillable casillero_destino) {
		for(int i = 0; i < iterador.size(); i++) {
			if(iterador.actual() == casillero_destino) return;
			iterador.next();
		}
	}
}
