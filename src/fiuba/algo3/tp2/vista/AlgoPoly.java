package fiuba.algo3.tp2.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AlgoPoly extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage);
		contenedorPrincipal.inicializar();
		
		Scene escenaPrincipal = new Scene(contenedorPrincipal);
		escenaPrincipal.getStylesheets().add("fiuba/algo3/tp2/vista/estilos/styles_1366x768.css");
		
		stage.setFullScreenExitHint("");
		stage.setTitle("AlgoPoly");
		stage.setScene(escenaPrincipal);
		
		stage.setMaximized(false);
		stage.setFullScreen(true);
		stage.setResizable(false);
		stage.show();
		
	}

	public static void main(String[] args) throws Exception {
		launch(args);
		System.out.println("FIN DEL PROGRAMA");
	}
	
	

	
}
