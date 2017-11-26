package fiuba.algo3.tp2.vista.partida.turno;

import javafx.scene.control.Label;

public class LabelTituloTurno extends Label{

	public LabelTituloTurno(String texto){
		this.getStyleClass().add("LabelTurnoTitulo");
		this.setText(texto);
	}
	
	public void cambiarTexto(String texto){
		this.setText(texto);
	}
}
