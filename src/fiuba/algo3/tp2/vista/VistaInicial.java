package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.vista.eventos.BotonIniciarPartidaHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaInicial extends VBox {
		
	public VistaInicial(Stage stage, Scene escenaPartida) {
		agregarBotonIniciarPartida(stage,escenaPartida);
		this.getStyleClass().add("VistaInicial");
	}
	
	private void agregarBotonIniciarPartida(Stage stage, Scene escenaPartida){
		BotonIniciarPartida botonIniciarPartida = new BotonIniciarPartida();
		botonIniciarPartida.setOnAction(new BotonIniciarPartidaHandler(stage,escenaPartida));
		this.getChildren().addAll(botonIniciarPartida);
	}
	
	
}
