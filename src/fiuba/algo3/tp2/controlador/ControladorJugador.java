package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.vista.partida.VistaJugador;

public class ControladorJugador {

	private Jugador jugador;
	private VistaJugador vista;
	
	public ControladorJugador(Jugador jugador){
		this.jugador=jugador;
	}
	
	public String getNombre(){
		return this.jugador.getNombre();
	}
	
	public String getDinero(){
		return String.valueOf(this.jugador.obtenerDinero().obtenerMontoEntero());
	}
	
}
