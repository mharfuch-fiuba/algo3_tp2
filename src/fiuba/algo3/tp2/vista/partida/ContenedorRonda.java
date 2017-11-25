package fiuba.algo3.tp2.vista.partida;

import fiuba.algo3.tp2.controlador.ControladorRonda;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class ContenedorRonda extends HBox{
	
	ControladorRonda controladorRonda;
	
	public ContenedorRonda(ControladorRonda controladorRonda){
		this.controladorRonda = controladorRonda;
		this.getStyleClass().add("VistaRonda");
		controladorRonda.agregarJugadores(this);

	}

}
