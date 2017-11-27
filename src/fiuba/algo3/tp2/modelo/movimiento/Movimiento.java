package fiuba.algo3.tp2.modelo.movimiento;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.JugadorEnCarcelException;
import fiuba.algo3.tp2.modelo.tablero.Encasillable;

public interface Movimiento {

	Encasillable verActual();
	void avanzarHasta(Encasillable casillero) throws JugadorEnCarcelException;
	void avanzar(int cantidadCasilleros) throws JugadorEnCarcelException;
	void retroceder(int cant_casilleros) throws JugadorEnCarcelException;
	void desencarcelar(Jugador jugador) throws DineroInsuficienteException;
	void avisarCambioDeTurno(Jugador jugador);
	
}
