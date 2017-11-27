package fiuba.algo3.tp2.vista.partida.turno;

import fiuba.algo3.tp2.controlador.ControladorRonda;
import javafx.scene.layout.HBox;

public class VistaTurnoTitulo extends HBox{

	ControladorRonda ronda;
	LabelTituloTurno jugador;
	
	public VistaTurnoTitulo(ControladorRonda ronda){
		this.ronda=ronda;
		this.getStyleClass().add("VistaTurnoTitulo");
		LabelTituloTurno fijo = new LabelTituloTurno("Turno de: ");
		this.jugador = new LabelTituloTurno(ronda.getNombreJugadorActual());
		this.getChildren().addAll(fijo,jugador);
	}
	
	public LabelTituloTurno getLabelJugador(){
		return this.jugador;
	}
	
}
