package fiuba.algo3.tp2.vista.partida;

import javafx.scene.layout.BorderPane;

public class ContenedorTablero extends BorderPane {

	public ContenedorTablero() {
		this.getStyleClass().add("VistaTablero");
		ContenedorTableroTop top = new ContenedorTableroTop();
		ContenedorTableroLeft left = new ContenedorTableroLeft();
		ContenedorTableroCenter center = new ContenedorTableroCenter();
		ContenedorTableroRight right = new ContenedorTableroRight();
		ContenedorTableroBottom bottom = new ContenedorTableroBottom();
		this.setTop(top);
		this.setLeft(left);
		this.setCenter(center);
		this.setRight(right);
		this.setBottom(bottom);
		
	}

}
