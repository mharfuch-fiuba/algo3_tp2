package fiuba.algo3.tp2.vista.partida.turno;

import javafx.scene.layout.VBox;

public class VistaTurnoIntercambiar extends VBox{

	public VistaTurnoIntercambiar(ContenedorTurno contenedorPadre) {
		this.getStyleClass().add("VistaTurnoDinamica");
		LabelTurnoDinamica intercambiar = new LabelTurnoDinamica("Elija qué desea intercambiar");
		this.getChildren().addAll(intercambiar);
		}

}
