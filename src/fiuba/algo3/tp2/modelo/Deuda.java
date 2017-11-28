package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public class Deuda {

	Dinero monto_deuda;
	
	public Deuda(Dinero monto) {
		monto_deuda = monto.clone();
	}

	public void pagarDeuda(Jugador jugador) throws DineroInsuficienteException {
		jugador.pagar(monto_deuda);
		monto_deuda = new Dinero(0);
	}
	
	public Deuda clone() {
		return new Deuda(monto_deuda);
	}
	
	public Dinero getDeuda() {
		return monto_deuda.clone();
	}

}
