package fiuba.algo3.tp2.vista.partida.turno;

import javafx.scene.layout.HBox;

public class VistaTurnoTitulo extends HBox{
	
	String titulo_actual;
	
	public VistaTurnoTitulo(String jugador_actual){
		this.getStyleClass().add("VistaTurnoTitulo");
		this.setTitulo("Indefinido");
	}

	public void setTitulo(String jugador_actual) {
		System.out.println("Turno de: " + jugador_actual);
		titulo_actual = "Turno de: " + jugador_actual;
		LabelTituloTurno texto_nombre_jugador = new LabelTituloTurno(titulo_actual);
		this.getChildren().clear();
		this.getChildren().add(texto_nombre_jugador);
	}
	
}
