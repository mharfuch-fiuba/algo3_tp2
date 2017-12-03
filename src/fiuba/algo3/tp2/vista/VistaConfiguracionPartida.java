package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.vista.botones.BotonAlgoPoly;
import fiuba.algo3.tp2.vista.botones.BotonIniciarPartida;
import fiuba.algo3.tp2.vista.botones.eventos.BotonIniciarPartidaHandler;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaConfiguracionPartida extends VBox {

	private TextFieldNombres textFieldNombres;

	public VistaConfiguracionPartida(ContenedorPrincipal stage) {
		
		this.textFieldNombres=new TextFieldNombres();
		this.getChildren().addAll(this.textFieldNombres);
		agregarBotonIniciarPartida(stage);
		this.getStyleClass().add("VistaConfiguracionPartida");
	}

	private void agregarBotonIniciarPartida(ContenedorPrincipal stage){
		BotonAlgoPoly botonIniciarPartida = new BotonIniciarPartida(stage,textFieldNombres);
		this.getChildren().addAll(botonIniciarPartida);
	}


	


}
