package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public class DeudaNull implements Adeudable {

	public void pagarDeuda(Jugador jugador) throws DineroInsuficienteException {
		jugador.pagar(new Dinero(0));
	}

}
