package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class IterTablero{

	private ArrayList<Encasillable> casilleros;
	private int pos_actual;

	public IterTablero(TableroAlgoPoly tablero) {
		this.casilleros = tablero.obtenerListaCasilleros();
		this.pos_actual = 0;
	}

	public Encasillable avanzar() {
		pos_actual++;
		try {
			return this.verActual();
		}catch (IndexOutOfBoundsException e) {
			pos_actual = 0;
			return this.verActual();
		}
	}
	
	public Encasillable retroceder() {
		pos_actual--;
		try {
			return this.verActual();
		}catch (IndexOutOfBoundsException e) {
			pos_actual = 0;
			return this.verActual();
		}
	}

	public Encasillable verActual() {
		return casilleros.get(pos_actual);
	}

	public void avanzarHasta(Encasillable casillero_destino) {
		int i = 0;
		for(Encasillable casillero_actual:casilleros) {
			if(casillero_actual == casillero_destino) {
				pos_actual = i;
			}
			i++;
		}
	}

}
