package fiuba.algo3.tp2.vista.partida;

import javafx.scene.layout.HBox;

public class ContenedorPartidaInferior extends HBox{

	public ContenedorPartidaInferior(){
		VistaRonda vistaRonda= new VistaRonda();
		ContenedorTurno contenedorTurno = new ContenedorTurno();
		this.getChildren().addAll(vistaRonda,contenedorTurno);
	}
}
