package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.controlador.ControladorRonda;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonComprarHandler implements EventHandler<ActionEvent> {

	private ContenedorTurno contenedorPadre;

	public BotonComprarHandler(ContenedorTurno contenedorPadre) {
		this.contenedorPadre = contenedorPadre;
	}

	@Override
	public void handle(ActionEvent event) {
		ControladorRonda ronda = this.contenedorPadre.getControladorRonda();
		ronda.getJugadorActual().comprarCasilleroActual();
		ronda.terminarTurno();
		this.contenedorPadre.cambiarVistaDinamica(this.contenedorPadre.getVistaInicial());
	}

}
