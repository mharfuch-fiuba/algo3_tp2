package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.controlador.ControladorPrincipal;
import fiuba.algo3.tp2.vista.botones.BotonAlgoPoly;
import fiuba.algo3.tp2.vista.botones.eventos.BotonNuevaPartidaHandler;
import fiuba.algo3.tp2.vista.pantallas.PantallaConfiguracionPartida;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaInicial extends VBox {
	
	private ControladorPrincipal controlador_principal;
	
	public VistaInicial(ContenedorPrincipal stage, ControladorPrincipal controlador_principal) {
		Image logo = new Image("file:assets/logo.png");
		ImageView vistaImagen = new ImageView(logo);
		vistaImagen.setFitHeight(240);
		vistaImagen.setFitWidth(800);
		this.getChildren().add(vistaImagen);
		agregarBotonNuevaPartida(stage);
		this.getStyleClass().add("VistaInicial");
		this.controlador_principal = controlador_principal;
	}
	
	private void agregarBotonNuevaPartida(ContenedorPrincipal stage){	
		PantallaConfiguracionPartida vistaConfiguracionPartida= new PantallaConfiguracionPartida(stage, controlador_principal);

		BotonAlgoPoly botonNuevaPartida = new BotonAlgoPoly("Nueva Partida");
		botonNuevaPartida.setOnAction(new BotonNuevaPartidaHandler(stage,vistaConfiguracionPartida));
		this.getChildren().add(botonNuevaPartida);
	}
	
}
