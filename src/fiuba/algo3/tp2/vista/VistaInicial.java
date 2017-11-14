package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.vista.eventos.BotonNuevaPartidaHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaInicial extends VBox {
		
	public VistaInicial(Stage stage, Scene escenaConfigurarPartida) {
		agregarBotonNuevaPartida(stage,escenaConfigurarPartida);
		this.getStyleClass().add("VistaInicial");
	}
	
	private void agregarBotonNuevaPartida(Stage stage, Scene escenaConfigurarPartida){
		BotonNuevaPartida botonNuevaPartida = new BotonNuevaPartida();
		botonNuevaPartida.setOnAction(new BotonNuevaPartidaHandler(stage,escenaConfigurarPartida));
		this.getChildren().add(botonNuevaPartida);
		
	}
	
}
