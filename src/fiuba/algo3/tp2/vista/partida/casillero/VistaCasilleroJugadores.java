package fiuba.algo3.tp2.vista.partida.casillero;

import javafx.scene.layout.HBox;


public class VistaCasilleroJugadores extends HBox {

	VistaCasilleroJugador jugador1;
	VistaCasilleroJugador jugador2;
	VistaCasilleroJugador jugador3;

	public VistaCasilleroJugadores() {
		this.getStyleClass().add("VistaCasilleroJugadores");
		jugador1=new VistaCasilleroJugador();
		jugador2=new VistaCasilleroJugador();
		jugador3=new VistaCasilleroJugador();
		this.getChildren().addAll(jugador1,jugador2,jugador3);
	}


	
}
