package fiuba.algo3.tp2.vista.partida;

import fiuba.algo3.tp2.controlador.ControladorJugador;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VistaJugador extends VBox{
	
	ControladorJugador controladorJugador;
	

	public VistaJugador(ControladorJugador controladorJugador){
		this.getStyleClass().add("VistaJugador");
		this.controladorJugador = controladorJugador;
		agregarNombre();
	}
	
	private void agregarNombre(){
		Label labelNombre = new Label(controladorJugador.getNombre());
		this.getChildren().add(labelNombre);
	}
	
}
