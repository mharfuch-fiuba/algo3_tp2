package fiuba.algo3.tp2.vista.eventos;
import fiuba.algo3.tp2.controlador.ControladorPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonIniciarPartidaHandler implements EventHandler<ActionEvent> {
	private Stage stage;
	private ControladorPartida controladorPartida;
	private Scene escenaPartida;

	public BotonIniciarPartidaHandler(Stage stage, ControladorPartida controladorPartida,Scene escenaPartida) {
		this.stage = stage;
		this.escenaPartida = escenaPartida;
	}

	@Override
	public void handle(ActionEvent event) {
		stage.setScene(escenaPartida);
		stage.setFullScreen(true);
	}

}
