package fiuba.algo3.tp2.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AlgoPoly extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
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

	public static void main(String[] args) throws Exception {
		launch(args);
	}
	
	
}
