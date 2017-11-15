package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public interface Encasillable {
	
	void aplicarEfecto(Jugador jugador,  Cubilete dados) throws DineroInsuficienteException;
	
}
