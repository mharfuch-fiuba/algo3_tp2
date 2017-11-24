package fiuba.algo3.tp2.vista.partida;

import javafx.scene.layout.VBox;

public class ContenedorTableroRight extends VBox {

	public ContenedorTableroRight() {
		for (int i = 0; i < 4; i++) {
			ContenedorCasillero c = new ContenedorCasillero();
			this.getChildren().add(c);
		}
	}

}
