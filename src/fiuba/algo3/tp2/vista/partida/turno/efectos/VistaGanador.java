package fiuba.algo3.tp2.vista.partida.turno.efectos;


import fiuba.algo3.tp2.vista.botones.BotonAlgoPoly;
import fiuba.algo3.tp2.vista.botones.eventos.OpcionReiniciarEventHandler;
import fiuba.algo3.tp2.vista.pantallas.PantallaConfiguracionPartida;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Label;


public class VistaGanador extends VBox{

	public VistaGanador(Stage stage) {
		Image logo = new Image("file:assets/logo.png");
		ImageView vistaImagen = new ImageView(logo);
		vistaImagen.setFitHeight(240);
		vistaImagen.setFitWidth(800);
		Label etiqueta = new Label();
		etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
		etiqueta.setText("Gano");
		etiqueta.setTextFill(Color.web("#FFFFFF"));
		
		this.getChildren().addAll(vistaImagen, etiqueta);
		agregarBotonReiniciar(stage);
		this.getStyleClass().add("VistaInicial");
	}
	
	private void agregarBotonReiniciar(Stage stage){	
		//VistaConfiguracionPartida vistaConfiguracionPartida= new VistaConfiguracionPartida(stage);
		//Scene escenaConfiguracionPartida = new Scene(vistaConfiguracionPartida);
		//escenaConfiguracionPartida.getStylesheets().add("fiuba/algo3/tp2/vista/estilos/styles_1366x768.css");

		BotonAlgoPoly botonReiniciar = new BotonAlgoPoly("Reiniciar");
		botonReiniciar.setOnAction(new OpcionReiniciarEventHandler(stage));
		this.getChildren().add(botonReiniciar);	
	}
}
