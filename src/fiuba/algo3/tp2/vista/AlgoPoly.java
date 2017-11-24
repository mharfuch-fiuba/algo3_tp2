package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.controlador.ControladorPartida;
import fiuba.algo3.tp2.vista.partida.ContenedorPartida;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AlgoPoly extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		ControladorPartida controladorPartida = new ControladorPartida();

		ContenedorPartida vistaPartida = new ContenedorPartida(stage,controladorPartida);	
		Scene escenaPartida = new Scene(vistaPartida);
		
		VistaConfiguracionPartida vistaConfiguracionPartida= new VistaConfiguracionPartida(stage,controladorPartida,escenaPartida);
		Scene escenaConfiguracionPartida = new Scene(vistaConfiguracionPartida);
		
		VistaInicial vistaInicial = new VistaInicial(stage,escenaConfiguracionPartida);
		Scene escenaInicial = new Scene(vistaInicial);
		
		escenaInicial.getStylesheets().add("fiuba/algo3/tp2/vista/styles_1366x768.css");
		escenaConfiguracionPartida.getStylesheets().add("fiuba/algo3/tp2/vista/styles_1366x768.css");
		escenaPartida.getStylesheets().add("fiuba/algo3/tp2/vista/styles_1366x768.css");
		//escenaPartida.setOnKeyPressed(new AplicacionOnKeyPressEventHandler(stage));
		
		stage.setFullScreenExitHint("");
		stage.setTitle("AlgoPoly");
		stage.setScene(escenaInicial);
		stage.setFullScreen(true);
		stage.setResizable(false);
		stage.show();
		
	}

	public static void main(String[] args) throws Exception {
		launch(args);
	}
	
	
}
