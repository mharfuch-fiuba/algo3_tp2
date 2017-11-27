package fiuba.algo3.tp2.vista.partida.turno;

import javafx.scene.layout.VBox;

public class VistaTurnoConstruir extends VBox{

	public VistaTurnoConstruir(ContenedorTurno contenedorPadre) {
		this.getStyleClass().add("VistaTurnoDinamica");
		LabelTurnoDinamica construir = new LabelTurnoDinamica("Elija dónde desea construir");
		this.getChildren().addAll(construir);
		}

}
