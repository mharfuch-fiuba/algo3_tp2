package fiuba.algo3.tp2.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AlgoPoly extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		//ControladorPrincipal controlador_principal = new ControladorPrincipal();
		ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage);
		contenedorPrincipal.inicializar();
		
		Scene escenaPrincipal = new Scene(contenedorPrincipal);
		escenaPrincipal.getStylesheets().add("fiuba/algo3/tp2/vista/estilos/styles_1366x768.css");
		
		stage.setFullScreenExitHint("");
		stage.setFullScreen(true);
		stage.setTitle("AlgoPoly");
		stage.setScene(escenaPrincipal);
		
		stage.setMaximized(false);
		stage.setFullScreen(false);
		stage.setResizable(false);
		stage.show();
		
	}

	public static void main(String[] args) throws Exception {
		launch(args);
		System.out.println("FIN DEL PROGRAMA");
	}
	
	

	
}
