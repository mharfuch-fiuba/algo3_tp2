package fiuba.algo3.tp2.vista.partida.turno;

import fiuba.algo3.tp2.controlador.ControladorJugador;
import javafx.scene.control.Label;

public class VistaJugadorEnCarcel extends VistaTurnoInicial {

	public VistaJugadorEnCarcel(ContenedorTurno contenedorPadre,ControladorJugador jugador) {
		super(contenedorPadre);
		this.getChildren().removeAll(this.getChildren());
		this.getChildren().add(new Label("ESTOY EN CARCEL"));
	}

	
}
