package fiuba.algo3.tp2.vista.partida.turno;

import javafx.scene.layout.VBox;

public class VistaTurnoVender extends VBox {

	public VistaTurnoVender(ContenedorTurno contenedorPadre) {
		this.getStyleClass().add("VistaTurnoDinamica");
		LabelTurnoDinamica vender = new LabelTurnoDinamica("Elija qué desea vender");
		this.getChildren().addAll(vender);
		}
	
}
