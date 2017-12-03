package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.controlador.ControladorRonda;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonPagarFianzaHandler implements EventHandler<ActionEvent> {

	private ContenedorTurno contenedorPadre;
	
	public BotonPagarFianzaHandler(ContenedorTurno contenedorPadre) {
		this.contenedorPadre=contenedorPadre;
	}

	@Override
	public void handle(ActionEvent event) {
		ControladorRonda ronda = this.contenedorPadre.getControladorRonda();
		ronda.getJugadorActual().pagarFianza();
	}

}
