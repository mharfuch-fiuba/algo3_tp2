package fiuba.algo3.tp2.modelo;

public class JugadorHumano extends Jugador {
	
	private IterTablero posicion;
	private Dinero dinero;
	
	public JugadorHumano(Tablero tablero) {
		this.posicion = tablero.crearIterador();
	}
	
	@Override
	public void avanzar(Cubilete cubilete) {
		int cant_casilleros = cubilete.sumarValores();
		for(int i = 0; i < cant_casilleros; i++) {
			this.posicion.avanzar();
		}
		//EJECUTA EL EFECTO DEL CASILLERO:
		Encasillable casillero = posicion.verActual();
		casillero.ejecutarEfecto(this);
	}

	@Override
	public Dinero obtenerDinero() {
		return this.dinero;
	}

	@Override
	public void incrementarDinero(Dinero monto) {
		this.dinero.agregarCantidad(monto);
	}
	
}
