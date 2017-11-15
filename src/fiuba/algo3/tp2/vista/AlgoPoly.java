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
		
		escenaInicial.getStylesheets().add("fiuba/algo3/tp2/vista/styles_hd.css");
		escenaConfiguracionPartida.getStylesheets().add("fiuba/algo3/tp2/vista/styles_hd.css");
		escenaPartida.getStylesheets().add("fiuba/algo3/tp2/vista/styles_hd.css");
		//escenaPartida.setOnKeyPressed(new AplicacionOnKeyPressEventHandler(stage));
		
		stage.setTitle("AlgoPoly");
		stage.setScene(escenaInicial);
		stage.show();
		stage.setResizable(false);
		stage.setMaximized(true);
		
	}

	public static void main(String[] args) throws Exception {
		launch(args);
	}
	
	
}
