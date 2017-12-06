package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.controlador.ControladorPrincipal;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import fiuba.algo3.tp2.vista.TextFieldNombres;
import fiuba.algo3.tp2.vista.botones.eventos.BotonIniciarPartidaHandler;
import fiuba.algo3.tp2.vista.botones.eventos.BotonReiniciarPartidaHandler;

public class BotonReiniciarPartida extends BotonAlgoPoly {

	public BotonReiniciarPartida() {
		this.setText("Iniciar Partida");
		this.setOnAction(new BotonReiniciarPartidaHandler());
	}
	
}
