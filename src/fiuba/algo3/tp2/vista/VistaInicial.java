package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.vista.botones.BotonNuevaPartida;
import fiuba.algo3.tp2.vista.eventos.BotonNuevaPartidaHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaInicial extends VBox {
		
	public VistaInicial(Stage stage) {
		Image logo = new Image("file:assets/logo.png");
		ImageView vistaImagen = new ImageView(logo);
		vistaImagen.setFitHeight(300);
		vistaImagen.setFitWidth(1000);
		this.getChildren().add(vistaImagen);
		agregarBotonNuevaPartida(stage);
		this.getStyleClass().add("VistaInicial");
	}
	
	private void agregarBotonNuevaPartida(Stage stage){	
		VistaConfiguracionPartida vistaConfiguracionPartida= new VistaConfiguracionPartida(stage);
		Scene escenaConfiguracionPartida = new Scene(vistaConfiguracionPartida);
		escenaConfiguracionPartida.getStylesheets().add("fiuba/algo3/tp2/vista/estilos/styles_1366x768.css");

		BotonNuevaPartida botonNuevaPartida = new BotonNuevaPartida();
		botonNuevaPartida.setOnAction(new BotonNuevaPartidaHandler(stage,escenaConfiguracionPartida));
		this.getChildren().add(botonNuevaPartida);	
	}
	
}
