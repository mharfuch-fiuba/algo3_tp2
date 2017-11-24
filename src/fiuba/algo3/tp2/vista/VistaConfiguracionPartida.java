package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.controlador.ControladorPartida;
import fiuba.algo3.tp2.vista.botones.BotonIniciarPartida;
import fiuba.algo3.tp2.vista.eventos.BotonIniciarPartidaHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaConfiguracionPartida extends VBox{

	public VistaConfiguracionPartida(Stage stage, ControladorPartida controladorPartida, Scene escenaPartida) {
		stage.setFullScreen(true);
		agregarTextFieldNombres();
		
		agregarBotonIniciarPartida(stage,controladorPartida,escenaPartida);
		this.getStyleClass().add("VistaConfiguracionPartida");	}

	private void agregarBotonIniciarPartida(Stage stage,ControladorPartida controladorPartida, Scene escenaPartida){
		BotonIniciarPartida botonIniciarPartida = new BotonIniciarPartida();
		botonIniciarPartida.setOnAction(new BotonIniciarPartidaHandler(stage,controladorPartida,escenaPartida));
		this.getChildren().addAll(botonIniciarPartida);
	}
	
	private void agregarTextFieldNombres(){
		TextFieldNombreJugador nombreJugador1 = new TextFieldNombreJugador("Jugador1");
		TextFieldNombreJugador nombreJugador2 = new TextFieldNombreJugador("Jugador2");
		TextFieldNombreJugador nombreJugador3 = new TextFieldNombreJugador("Jugador3");
		this.getChildren().addAll(nombreJugador1,nombreJugador2,nombreJugador3);
	}
	
}
