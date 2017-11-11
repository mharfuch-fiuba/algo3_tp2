package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class IterTablero {
	
	private ArrayList<Encasillable> casilleros;
	private int pos_actual;

	public IterTablero(TableroAlgoPoly tablero) {
		this.casilleros = tablero.obtenerListaCasilleros();
		this.pos_actual = 0;
	}

	public void avanzar() {
		if(pos_actual + 1 < casilleros.size()) {
			pos_actual++;
		}
		pos_actual = 0;
	}

	public Encasillable verActual() {
		return casilleros.get(pos_actual);
	}

}
