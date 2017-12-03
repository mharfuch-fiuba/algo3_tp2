package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.vista.botones.BotonContinuar;
import javafx.scene.control.Label;


public class VistaJugadorEliminado extends VistaEfecto {
	
	public VistaJugadorEliminado(Jugador jugador){
		Label label = new Label(jugador.getNombre() + "Quedaste Eliminado del Juego!");
		BotonContinuar boton = new BotonContinuar(null);
		this.getChildren().addAll(label,boton);
	}
}
