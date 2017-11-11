package fiuba.algo3.tp2.modelo;

public class Jugador implements movible {

	private IterTablero posicion;
	private Dinero dinero;
	
	public Jugador(Tablero tablero) {
		this.posicion = tablero.crearIterador();
	}
	
	@Override
	public void avanzar(Cubilete cubilete) {
		int cant_casilleros = cubilete.sumarValores();
		for(int i = 0; i < cant_casilleros; i++) {
			this.posicion.avanzar();
		}
		//EJECUTA EL EFECTO DEL CASILLERO:
		Casillero casillero = posicion.verActual();
		casillero.ejecutarEfecto(this);
	}

	public Dinero obtenerDinero() {
		return this.dinero;
	}
	
}
