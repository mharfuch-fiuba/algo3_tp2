package fiuba.algo3.tp2.vista.partida;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class ContenedorTableroBottom extends HBox {

	public ContenedorTableroBottom() {
		for (int i = 0; i < 6; i++) {
			ContenedorCasillero c = new ContenedorCasillero();
			HBox.setHgrow(c, Priority.ALWAYS);
			this.getChildren().add(c);
		}
	}
}
