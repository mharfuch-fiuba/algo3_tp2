package fiuba.algo3.tp2.vista.partida.casillero;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class VistaCasilleroJugadores extends HBox {

	private Circle jugador1;
	private Circle jugador2;
	private Circle jugador3;

	public VistaCasilleroJugadores() {
		this.getStyleClass().add("VistaCasilleroJugadores");
		jugador1 = crearCirculoVacio();
		jugador2 = crearCirculoVacio();
		jugador3 = crearCirculoVacio();
		this.getChildren().addAll(jugador1,jugador2,jugador3);

	}

	private Circle crearCirculoVacio() {
		Circle circulo = new Circle();
		circulo.setRadius(10);
		circulo.setStroke(Color.BLACK);
		circulo.setFill(Color.WHITE);
		return circulo;
	}

}
