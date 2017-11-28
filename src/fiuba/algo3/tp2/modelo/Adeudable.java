package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public interface Adeudable {
	void pagarDeuda(Jugador jugador) throws DineroInsuficienteException;
}
