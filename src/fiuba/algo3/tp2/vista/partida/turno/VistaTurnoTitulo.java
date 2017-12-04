package fiuba.algo3.tp2.vista.partida.turno;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class VistaTurnoTitulo extends HBox{
	
	public VistaTurnoTitulo(String jugador_actual, Color color){
		this.getStyleClass().add("VistaTurnoTitulo");
		String titulo_actual = "Turno de: " + jugador_actual;
		LabelTituloTurno texto_nombre_jugador = new LabelTituloTurno(titulo_actual);
		texto_nombre_jugador.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
		this.getChildren().clear();
		this.getChildren().add(texto_nombre_jugador);
	}
	
}
