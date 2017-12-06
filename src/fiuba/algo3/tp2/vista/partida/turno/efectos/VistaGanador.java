package fiuba.algo3.tp2.vista.partida.turno.efectos;


import fiuba.algo3.tp2.controlador.ControladorJugador;
import fiuba.algo3.tp2.vista.botones.BotonAlgoPoly;
import fiuba.algo3.tp2.vista.botones.BotonReiniciarPartida;
import fiuba.algo3.tp2.vista.botones.eventos.OpcionReiniciarEventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class VistaGanador extends VistaAccion {

	public VistaGanador(String jugador) {
		Image logo = new Image("file:assets/logo.png");
		ImageView vistaImagen = new ImageView(logo);
		vistaImagen.setFitHeight(240);
		vistaImagen.setFitWidth(800);
		Label etiqueta = new Label();
		etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
		etiqueta.setText("Gano"+jugador);
		etiqueta.setTextFill(Color.web("#FFFFFF"));
		
		this.getChildren().addAll(vistaImagen, etiqueta);
		agregarBotonReiniciar();
		this.getStyleClass().add("VistaInicial");
	}
	
	private void agregarBotonReiniciar(){	
		//VistaConfiguracionPartida vistaConfiguracionPartida= new VistaConfiguracionPartida(stage);
		//Scene escenaConfiguracionPartida = new Scene(vistaConfiguracionPartida);
		//escenaConfiguracionPartida.getStylesheets().add("fiuba/algo3/tp2/vista/estilos/styles_1366x768.css");

		BotonAlgoPoly botonReiniciar = new BotonReiniciarPartida();
		this.getChildren().add(botonReiniciar);	
	}
}
