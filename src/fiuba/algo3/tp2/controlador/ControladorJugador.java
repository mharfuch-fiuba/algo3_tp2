package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.vista.partida.VistaJugador;
import javafx.scene.paint.Color;

public class ControladorJugador {

	private Jugador jugador;
	private VistaJugador vista;
	
	public ControladorJugador(Jugador jugador){
		this.jugador=jugador;
	}
	
	public String getNombre(){
		return this.jugador.getNombre();
	}
	
	public Color getColor(){
		return this.jugador.getColor();
	}
	
	public String getDinero(){
		return String.valueOf(this.jugador.obtenerDinero().obtenerMontoEntero());
	}
	
}
