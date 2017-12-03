package fiuba.algo3.tp2.vista.partida.turno;

import fiuba.algo3.tp2.controlador.ControladorJugador;
import fiuba.algo3.tp2.vista.botones.BotonPagarFianza;
import fiuba.algo3.tp2.vista.botones.BotonTerminarTurno;
import javafx.scene.control.Label;

public class VistaJugadorEnCarcel extends VistaTurnoInicial {

	public VistaJugadorEnCarcel(ContenedorTurno contenedorPadre,ControladorJugador jugador) {
		super(contenedorPadre);
		this.getChildren().removeAll(this.getChildren());
		BotonPagarFianza botonFianza = new BotonPagarFianza(contenedorPadre);
		BotonTerminarTurno botonTerminar = new BotonTerminarTurno(contenedorPadre);
		this.getChildren().addAll(new Label("ESTOY EN CARCEL"),botonFianza,botonTerminar);
		
	}

	
}
