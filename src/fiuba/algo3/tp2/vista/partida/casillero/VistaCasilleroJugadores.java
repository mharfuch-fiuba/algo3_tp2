package fiuba.algo3.tp2.vista.partida.casillero;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class VistaCasilleroJugadores extends HBox{

	public VistaCasilleroJugadores(){
		this.getStyleClass().add("VistaCasilleroJugadores");
		this.getChildren().add(new Label("JUGADORES"));	
	}
}
