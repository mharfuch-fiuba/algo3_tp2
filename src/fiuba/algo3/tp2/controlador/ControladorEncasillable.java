package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.tablero.Encasillable;
import fiuba.algo3.tp2.vista.partida.casillero.ContenedorCasillero;

public abstract class ControladorEncasillable {
	//abstracta porque creo que vamos a tener diferencias entre los distintos tipos

	private Encasillable modelo;
	private ContenedorCasillero vista;

	// mostrar en sector superior
	public abstract String getNombre();

	// mostrar en sector medio
	public abstract String getEstado();

	// mostrar en sector inferior
	public abstract Jugador[] getJugadores();

}
