package fiuba.algo3.tp2.modelo;

public class JugadorHumano extends Jugador {
	
	private static final double DINERO_INICIAL = 100000;
	private IterTablero posicion;
	private Dinero dinero;
	
	public JugadorHumano(Tablero tablero) {
		this.posicion = tablero.crearIterador();
		this.dinero = new Dinero(DINERO_INICIAL);
	}
	
	@Override
	public void avanzar(Cubilete cubilete) {
		int cant_casilleros = cubilete.sumarValores();
		for(int i = 0; i < cant_casilleros; i++) {
			this.posicion.avanzar();
		}
		//EJECUTA EL EFECTO DEL CASILLERO:
		Encasillable casillero = posicion.verActual();
		casillero.ejecutarEfecto(this, cubilete);
	}

	@Override
	public Dinero obtenerDinero() {
		return this.dinero;
	}

	@Override
	public void incrementarDinero(Dinero monto) {
		this.dinero.aumentarCantidad(monto);
	}

	@Override
	public void comprarCasilleroActual() {
		Comprable casillero = (Comprable) posicion.verActual();
		casillero.comprar(this);
	}

	@Override
	public Encasillable obtenerCasilleroActual() {
		return posicion.verActual();
	}

	@Override
	public void disminuirCapital(Dinero monto) {
		dinero.disminuirCantidad(monto);
	}

	@Override
	public void aumentarCapital(Dinero monto) {
		dinero.aumentarCantidad(monto);
	}
	
}
