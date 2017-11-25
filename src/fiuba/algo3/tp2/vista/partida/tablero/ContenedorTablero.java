package fiuba.algo3.tp2.vista.partida.tablero;

import fiuba.algo3.tp2.controlador.ControladorTablero;
import javafx.scene.layout.BorderPane;

public class ContenedorTablero extends BorderPane {

	public ContenedorTablero(ControladorTablero controladorTablero) {
		this.getStyleClass().add("VistaTablero");
		
		ContenedorTableroHorizontal bottom = new ContenedorTableroHorizontal(controladorTablero.getControladoresAbajo());
		ContenedorTableroVertical left = new ContenedorTableroVertical(controladorTablero.getControladoresIzquierda());
		ContenedorTableroHorizontal top = new ContenedorTableroHorizontal(controladorTablero.getControladoresArriba());
		ContenedorTableroVertical right = new ContenedorTableroVertical(controladorTablero.getControladoresDerecha());
		
		ContenedorTableroCenter center = new ContenedorTableroCenter();
		
		this.setTop(top);
		this.setLeft(left);
		this.setCenter(center);
		this.setRight(right);
		this.setBottom(bottom);
	}

	
	
}
