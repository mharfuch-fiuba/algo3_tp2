package fiuba.algo3.tp2.vista.partida.turno;

import javafx.scene.layout.VBox;

public class VistaTurnoIntercambiar extends VBox{

	public VistaTurnoIntercambiar(VistaAcciones contenedorPadre) {
		this.getStyleClass().add("VistaTurnoDinamica");
		LabelTurnoDinamica intercambiar = new LabelTurnoDinamica("Elija qu� desea intercambiar");
		//this.getChildren().addAll(intercambiar,contenedorPadre.getBotonVolver());
		}

}
