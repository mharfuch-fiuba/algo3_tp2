package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.JugadorEnCarcelException;

public class JugadorHumano extends Jugador {

	private IterTablero posicion;
	private Dinero dinero;
	private int turnos_de_carcel;
	
	private ArrayList<Comprable> propiedades;

	public JugadorHumano(Tablero tablero, Dinero dinero_inicial) {
		posicion = tablero.crearIterador();
		dinero = dinero_inicial;
		turnos_de_carcel = 0;
		propiedades = new ArrayList<Comprable>();
	}
	public void agregarPropiedad(Comprable propiedad) {
		propiedades.add(propiedad);
	}
	
	@Override
	public void avanzar(int cant_casilleros) {
		for (int i = 0; i < cant_casilleros; i++) {
			this.posicion.avanzar();
		}
	}

	@Override
	public void avanzar(Cubilete cubilete) throws JugadorEnCarcelException {
		if(turnos_de_carcel == 0) {
			this.avanzar(cubilete.sumarValores());
			return;
		}
		throw new JugadorEnCarcelException();
	}

	@Override
	public void retroceder(int cant_casilleros) {
		for (int i = 0; i < cant_casilleros; i++) {
			this.posicion.retroceder();
		}
	}
	
	@Override
	public void retroceder(Cubilete cubilete) throws JugadorEnCarcelException {
		if(turnos_de_carcel == 0) {
			this.retroceder(cubilete.sumarValores());
			return;
		}
		throw new JugadorEnCarcelException();
	}

	@Override
	public Dinero obtenerDinero() {
		return this.dinero;
	}

	@Override
	public void cobrar(Dinero monto) {
		//GUARDA QUE HACE LO MISMO QUE AUMENTAR CAPITAL
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
	public void pagarFianza() throws DineroInsuficienteException {
		if (turnos_de_carcel != 2 && turnos_de_carcel != 1)
			return;
		this.pagar(new DineroAlgoPoly(45000));
		turnos_de_carcel = 0;
	}

	@Override
	public void encarcelar() {
		turnos_de_carcel = 3;
	}

	@Override
	public int getCantidadDePropiedades() {
		return propiedades.size();
	}

	@Override
	public void aplicarEfectoDeCasilleroActual(Cubilete cubilete) throws DineroInsuficienteException {
		Encasillable casillero = posicion.verActual();
		casillero.aplicarEfecto(this, cubilete);
	}

	@Override
	public void avanzarHasta(Encasillable casillero) {
		posicion.avanzarHasta(casillero);
	}

	@Override
	public Dinero pagar(Dinero monto) throws DineroInsuficienteException {
		this.dinero.disminuirCantidad(monto);
		return monto;
	}
	@Override
	public void disminuirDiasDeCarcel() {
		if (turnos_de_carcel <= 0) return;
		turnos_de_carcel --;
	}

}
