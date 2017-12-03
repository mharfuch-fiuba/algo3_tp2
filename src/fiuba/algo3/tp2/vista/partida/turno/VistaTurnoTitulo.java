package fiuba.algo3.tp2.vista.partida.turno;

import fiuba.algo3.tp2.modelo.Jugador;
import javafx.scene.layout.HBox;

public class VistaTurnoTitulo extends HBox{
	
	public VistaTurnoTitulo(Jugador jugador_actual){
		this.getStyleClass().add("VistaTurnoTitulo");
		LabelTituloTurno texto_nombre_jugador = new LabelTituloTurno("Turno de: " + jugador_actual);
		this.getChildren().addAll(texto_nombre_jugador);
	}
	
}
