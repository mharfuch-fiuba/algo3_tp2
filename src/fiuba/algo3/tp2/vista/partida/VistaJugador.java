package fiuba.algo3.tp2.vista.partida;

import fiuba.algo3.tp2.controlador.ControladorJugador;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class VistaJugador extends VBox{
	
	ControladorJugador controladorJugador;
	

	public VistaJugador(ControladorJugador controladorJugador){
		this.getStyleClass().add("VistaJugador");
		this.controladorJugador = controladorJugador;
		mostrarNombre();
		mostrarDinero();
		mostrarColor();
	}
	
	private void mostrarNombre(){
		Label labelNombre = new Label(controladorJugador.getNombre());
		this.getChildren().add(labelNombre);
	}
	
	private void mostrarDinero(){
		Label labelDinero = new Label(controladorJugador.getDinero());
		this.getChildren().add(labelDinero);
	}
	
	private void mostrarColor(){
		Color color = controladorJugador.getColor();
		Background background = new Background(new BackgroundFill(color,CornerRadii.EMPTY , Insets.EMPTY));
		this.setBackground(background);
	}
	
	
}
