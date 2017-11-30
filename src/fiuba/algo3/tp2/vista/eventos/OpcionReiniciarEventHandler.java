package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.vista.VistaInicial;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OpcionReiniciarEventHandler implements EventHandler<ActionEvent> {

	Stage stage;
	public OpcionReiniciarEventHandler(Stage stage){
		this.stage = stage;
	}
	
	@Override
	public void handle(ActionEvent actionEvent){
		VistaInicial vistaInicial = new VistaInicial(stage);
		Scene escenaInicial = new Scene(vistaInicial);
		escenaInicial.getStylesheets().add("fiuba/algo3/tp2/vista/estilos/styles_1366x768.css");
		
		stage.setFullScreenExitHint("");
		stage.setFullScreen(true);
		stage.setTitle("AlgoPoly");
		stage.setScene(escenaInicial);
		
		stage.setMaximized(false);
		stage.setResizable(false);
		stage.show();
	}
}
