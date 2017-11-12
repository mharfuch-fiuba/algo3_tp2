package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class JugadorHumano extends Jugador {

	// private static final double DINERO_INICIAL = 100000;
	private IterTablero posicion;
	private Dinero dinero;
	private int dias_de_carcel;
	public int nombreJugador;
	private ArrayList<Comprable> propiedades;

	public JugadorHumano(Tablero tablero, Dinero dinero_inicial) {
		this.posicion = tablero.crearIterador();
		this.dinero = dinero_inicial;
		this.dias_de_carcel = 0;
		this.propiedades=new ArrayList<Comprable>();
	}

	@Override
	public void agregarNombre(int nombre){
		nombreJugador=nombre;
	}
	
	@Override
	public void avanzar(Cubilete cubilete) throws DineroInsuficienteException {
		if (dias_de_carcel != 0) {
			dias_de_carcel--;
			return;
		} // ESTO SE PUEDE HACER DE OTRA FORMA
		int cant_casilleros = cubilete.sumarValores();
		System.out.println("voy a avanzar: " + cant_casilleros);
		this.avanzar(cant_casilleros);
		// EJECUTA EL EFECTO DEL CASILLERO:
		Encasillable casillero = posicion.verActual();
		casillero.ejecutarEfecto(this, cubilete);
	}

	@Override
	public void retroceder(Cubilete cubilete) throws DineroInsuficienteException {
		if (dias_de_carcel != 0) {
			dias_de_carcel--;
			return;
		} // ESTO SE PUEDE HACER DE OTRA FORMA
		int cant_casilleros = cubilete.sumarValores();
		System.out.println("voy a retroceder: " + cant_casilleros);
		this.retroceder(cant_casilleros);
		// EJECUTA EL EFECTO DEL CASILLERO:
		Encasillable casillero = posicion.verActual();
		casillero.ejecutarEfecto(this, cubilete);
	}
	
	public int getNombre(){
		return nombreJugador+1;
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
	public void comprarCasilleroActual() throws DineroInsuficienteException {
		Comprable casillero = (Comprable) posicion.verActual();
		casillero.comprar(this);
		propiedades.add(casillero);
	}

	@Override
	public Encasillable obtenerCasilleroActual() {
		return posicion.verActual();
	}

	@Override
	public void disminuirCapital(Dinero monto) throws DineroInsuficienteException {
		try {
			dinero.disminuirCantidad(monto);
		} catch (DineroNegativoException e) {
			throw new DineroInsuficienteException();
		}
	}

	@Override
	public void aumentarCapital(Dinero monto) {
		dinero.aumentarCantidad(monto);
	}

	@Override
	public void pagarFianza() throws DineroInsuficienteException {
		if (dias_de_carcel != 2 && dias_de_carcel != 1)
			return;
		try {
			this.disminuirCapital(new Dinero(45000));
		} catch (DineroInsuficienteException e) {
			throw new DineroInsuficienteException();
		}
		dias_de_carcel = 0;
	}

	@Override
	public void encarcelar() {
		dias_de_carcel = 3;
	}

	public void avanzar(int cant_casilleros) {
		for (int i = 0; i < cant_casilleros; i++) {
			this.posicion.avanzar();
		}
	}

	private void retroceder(int cant_casilleros) {
		for (int i = 0; i < cant_casilleros; i++) {
			this.posicion.retroceder();
		}
	}

	@Override
	public int getCantidadDePropiedades() {
		return propiedades.size();
	}
}
