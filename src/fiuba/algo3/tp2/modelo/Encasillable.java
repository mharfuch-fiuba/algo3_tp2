package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public interface Encasillable {
	
	void ejecutarEfecto(Jugador jugador,  Cubilete dados) throws DineroInsuficienteException;
	
}
