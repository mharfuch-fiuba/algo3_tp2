package fiuba.algo3.tp2.vista.partida;

import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ContenedorTableroRight extends VBox {

	public ContenedorTableroRight() {
		for (int i = 0; i < 4; i++) {
			ContenedorCasillero c = new ContenedorCasillero();
			VBox.setVgrow(c, Priority.ALWAYS);
			this.getChildren().add(c);
		}
	}

}
