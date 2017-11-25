package fiuba.algo3.tp2.modelo.tablero;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public interface Encasillable {	
	public String getNombre();
	void aplicarEfecto(Jugador jugador,  Cubilete dados) throws DineroInsuficienteException;
	
}
