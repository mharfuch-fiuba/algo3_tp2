package fiuba.algo3.tp2.vista.partida.casillero;

import javafx.scene.layout.VBox;

public class ContenedorCasillero extends VBox{
	
	public ContenedorCasillero(){
		this.getStyleClass().add("VistaCasillero");
		VistaCasilleroNombre nombre = new VistaCasilleroNombre();
		VistaCasilleroDetalle detalle = new VistaCasilleroDetalle();
		VistaCasilleroJugadores jugadores = new VistaCasilleroJugadores();
		nombre.setPrefHeight(this.getPrefHeight()/3);
		detalle.setPrefHeight(this.getPrefHeight()/3);
		jugadores.setPrefHeight(this.getPrefHeight()/3);
		this.getChildren().addAll(nombre,detalle,jugadores);

	}

}
