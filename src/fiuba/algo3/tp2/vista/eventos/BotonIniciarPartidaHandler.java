package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.controlador.ControladorPartida;
import fiuba.algo3.tp2.vista.TextFieldNombres;
import fiuba.algo3.tp2.vista.partida.ContenedorPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonIniciarPartidaHandler implements EventHandler<ActionEvent> {

	private Stage stage;
	private TextFieldNombres textFieldNombres;

	public BotonIniciarPartidaHandler(Stage stage, TextFieldNombres textFieldNombres ) {
		this.textFieldNombres = textFieldNombres;
		this.stage = stage;
	}

	@Override
	public void handle(ActionEvent event) {
		ControladorPartida controladorPartida = new ControladorPartida();
		controladorPartida.nuevaPartida(this.textFieldNombres.getNombres());

		ContenedorPartida vistaPartida = new ContenedorPartida(stage, controladorPartida);
		Scene escenaPartida = new Scene(vistaPartida);
		escenaPartida.getStylesheets().add("fiuba/algo3/tp2/vista/estilos/styles_1366x768.css");

		stage.setScene(escenaPartida);
		stage.setFullScreen(true);
	}

}
