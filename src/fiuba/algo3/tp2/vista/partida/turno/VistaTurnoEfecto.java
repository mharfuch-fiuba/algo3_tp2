package fiuba.algo3.tp2.vista.partida.turno;

import fiuba.algo3.tp2.vista.botones.BotonTerminarTurno;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaAccion;
import javafx.scene.layout.VBox;

public class VistaTurnoEfecto extends VBox {

	public VistaTurnoEfecto(VistaAcciones contenedorPadre,VistaAccion vistaEfecto) {
		this.getStyleClass().add("VistaTurnoDinamica");
		BotonTerminarTurno boton = new BotonTerminarTurno(contenedorPadre);
		this.getChildren().addAll(vistaEfecto,boton);
	}

	
}
