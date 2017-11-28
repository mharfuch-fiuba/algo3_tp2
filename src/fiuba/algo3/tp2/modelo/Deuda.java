package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public class Deuda implements Adeudable {

	Dinero monto_deuda;
	
	public Deuda(Dinero monto) {
		monto_deuda = monto.clone();
	}

	@Override
	public void pagarDeuda(Jugador jugador) throws DineroInsuficienteException {
		jugador.pagar(monto_deuda);
	}

}
