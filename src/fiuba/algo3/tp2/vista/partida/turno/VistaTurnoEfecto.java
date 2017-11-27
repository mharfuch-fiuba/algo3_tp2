package fiuba.algo3.tp2.vista.partida.turno;

import fiuba.algo3.tp2.vista.botones.BotonTerminarTurno;
import javafx.scene.layout.VBox;

public class VistaTurnoEfecto extends VBox {

	public VistaTurnoEfecto(ContenedorTurno contenedorPadre) {
		this.getStyleClass().add("VistaTurnoDinamica");
		LabelTurnoDinamica efecto = new LabelTurnoDinamica("Efecto");
		BotonTerminarTurno boton = new BotonTerminarTurno(contenedorPadre);
		this.getChildren().addAll(efecto,boton);
	}

}
