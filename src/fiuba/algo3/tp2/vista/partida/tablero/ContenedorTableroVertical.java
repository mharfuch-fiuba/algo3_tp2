package fiuba.algo3.tp2.vista.partida.tablero;

import java.util.ArrayList;

import fiuba.algo3.tp2.controlador.ControladorEncasillable;
import fiuba.algo3.tp2.vista.partida.casillero.ContenedorCasillero;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ContenedorTableroVertical extends VBox {

	public ContenedorTableroVertical(ArrayList<ControladorEncasillable> controladores) {
		for (ControladorEncasillable controlador:controladores) {
			ContenedorCasillero c = new ContenedorCasillero(controlador.getNombre());
			HBox.setHgrow(c, Priority.ALWAYS);
			controlador.asociarVista(c);
			this.getChildren().add(c);
		}
	}

}
