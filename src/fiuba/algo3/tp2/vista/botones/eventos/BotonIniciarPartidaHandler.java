package fiuba.algo3.tp2.vista.botones.eventos;

import java.util.ArrayList;

import fiuba.algo3.tp2.controlador.ControladorPrincipal;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import fiuba.algo3.tp2.vista.TextFieldNombres;
import fiuba.algo3.tp2.vista.partida.PantallaPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonIniciarPartidaHandler implements EventHandler<ActionEvent> {

	private ContenedorPrincipal stage;
	private TextFieldNombres textFieldNombres;

	public BotonIniciarPartidaHandler(ContenedorPrincipal stage, TextFieldNombres textFieldNombres ) {
		this.textFieldNombres = textFieldNombres;
		this.stage = stage;
	}

	@Override
	public void handle(ActionEvent event) {
		ControladorPrincipal controlador_principal = new ControladorPrincipal();
		ArrayList<String> nombres = this.textFieldNombres.getNombres();
		controlador_principal.agregarJugadores(nombres);
		controlador_principal.iniciar_partida(this.stage);


	}

}
