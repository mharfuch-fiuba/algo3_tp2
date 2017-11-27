package fiuba.algo3.tp2.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonNuevaPartidaHandler implements EventHandler<ActionEvent> {
	private Stage stage;
	private Scene escenaConfigurarPartida;

	public BotonNuevaPartidaHandler(Stage stage, Scene escenaConfigurarPartida) {
		this.stage = stage;
		this.escenaConfigurarPartida = escenaConfigurarPartida;
	}

	@Override
	public void handle(ActionEvent event) {
		
		stage.setScene(escenaConfigurarPartida);
		stage.setFullScreen(true);
	}

}
