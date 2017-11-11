package fiuba.algo3.tp2.modelo;

public abstract class Tablero {
	protected DoublyCircularList casilleros;

	public IterTablero crearIterador() {
		return casilleros.iterator();
	}
	
}
