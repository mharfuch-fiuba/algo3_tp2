package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.vista.botones.BotonIniciarPartida;
import fiuba.algo3.tp2.vista.eventos.BotonIniciarPartidaHandler;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaConfiguracionPartida extends VBox {

	private TextFieldNombres textFieldNombres;

	public VistaConfiguracionPartida(Stage stage) {
		stage.setFullScreen(true);
		this.textFieldNombres=new TextFieldNombres();
		this.getChildren().addAll(this.textFieldNombres);
		agregarBotonIniciarPartida(stage);
		this.getStyleClass().add("VistaConfiguracionPartida");
	}

	private void agregarBotonIniciarPartida(Stage stage){
		BotonIniciarPartida botonIniciarPartida = new BotonIniciarPartida();
		botonIniciarPartida.setOnAction(new BotonIniciarPartidaHandler(stage,textFieldNombres));
		this.getChildren().addAll(botonIniciarPartida);
	}


	


}
