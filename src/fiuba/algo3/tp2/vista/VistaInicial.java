package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.vista.botones.BotonAlgoPoly;
import fiuba.algo3.tp2.vista.botones.eventos.BotonNuevaPartidaHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaInicial extends VBox {
		
	public VistaInicial(ContenedorPrincipal stage) {
		Image logo = new Image("file:assets/logo.png");
		ImageView vistaImagen = new ImageView(logo);
		vistaImagen.setFitHeight(240);
		vistaImagen.setFitWidth(800);
		this.getChildren().add(vistaImagen);
		agregarBotonNuevaPartida(stage);
		this.getStyleClass().add("VistaInicial");
	}
	
	private void agregarBotonNuevaPartida(ContenedorPrincipal stage){	
		VistaConfiguracionPartida vistaConfiguracionPartida= new VistaConfiguracionPartida(stage);

		BotonAlgoPoly botonNuevaPartida = new BotonAlgoPoly("Nueva Partida");
		botonNuevaPartida.setOnAction(new BotonNuevaPartidaHandler(stage,vistaConfiguracionPartida));
		this.getChildren().add(botonNuevaPartida);
	}
	
}
