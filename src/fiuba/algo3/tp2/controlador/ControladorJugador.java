package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.vista.partida.VistaJugador;

public class ControladorJugador {

	private Jugador jugador;
	private VistaJugador vista;
	
	public ControladorJugador(){
		
	}
	
	public String getNombre(){
		return this.jugador.getNombre();
	}
	
}
