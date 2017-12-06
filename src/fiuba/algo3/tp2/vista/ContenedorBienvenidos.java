package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.vista.botones.eventos.BotonEntrarEventHandler;
import fiuba.algo3.tp2.vista.botones.eventos.OpcionSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorBienvenidos extends VBox {

	public ContenedorBienvenidos(Stage stage, Scene proximaEscena) {

		super();
		this.setAlignment(Pos.BOTTOM_CENTER);
		this.setSpacing(20);
		this.setPadding(new Insets(25));
		Image imagen = new Image("file:assets/logo.jpg");
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT, new BackgroundSize(1,1,true,true,false,false));
		this.setBackground(new Background(imagenDeFondo));

		Button botonEntrar = new Button();
		botonEntrar.setText("Iniciar Partida");
		botonEntrar.setMinHeight(50);
		botonEntrar.setMinWidth(100);

		BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage, proximaEscena);///////////////////
		botonEntrar.setOnAction(botonEntrarHandler);

		Label etiqueta = new Label();
		etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));

		Button botonSalir = new Button();
		botonSalir.setText("Salir");
		botonSalir.setMinHeight(50);
		botonSalir.setMinWidth(100);

		OpcionSalirEventHandler botonSalirHandler = new OpcionSalirEventHandler();
		botonSalir.setOnAction(botonSalirHandler);

		etiqueta.setText(
				"Haga click en el boton para iniciar la partida.");
		etiqueta.setTextFill(Color.web("#000000"));

		this.getChildren().addAll(etiqueta, botonEntrar, botonSalir);
	}

}
