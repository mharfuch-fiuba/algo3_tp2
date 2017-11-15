package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public class JugadorNull extends Jugador {

	@Override
	public void avanzar(Cubilete cubilete) {
		// TODO Auto-generated method stub

	}

	@Override
	public DineroAlgoPoly obtenerDinero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void comprarCasilleroActual() {
		// TODO Auto-generated method stub

	}

	@Override
	public Encasillable obtenerCasilleroActual() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aumentarCapital(Dinero monto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pagarFianza() {
		// TODO Auto-generated method stub

	}

	@Override
	public void encarcelar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void retroceder(Cubilete cubilete) {
		// TODO Auto-generated method stub

	}

	/*
	 * @Override public int getNombre() { // TODO Auto-generated method stub
	 * return 0; }
	 * 
	 * @Override public void agregarNombre(int nombre) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 */
	@Override
	public int getCantidadDePropiedades() {
		return 0;
	}

	@Override
	public void aplicarEfectoDeCasilleroActual(Cubilete cubilete) throws DineroInsuficienteException {
		// TODO Auto-generated method stub

	}

	@Override
	public Dinero pagar(Dinero monto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void avanzarHasta(Encasillable casillero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarPropiedad(Comprable propiedad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarDinero(Dinero monto) {
		// TODO Auto-generated method stub
		
	}

}
