package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.utils.DoublyCircularList;

public abstract class Tablero {
	protected DoublyCircularList casilleros;

	public IterTablero crearIterador() {
		return casilleros.iterator();
	}
	
}
