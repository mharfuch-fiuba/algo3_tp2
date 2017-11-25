package fiuba.algo3.tp2.vista.partida.casillero;

import javafx.scene.layout.VBox;

public class ContenedorCasillero extends VBox{
	
	private VistaCasilleroNombre nombre;
	private VistaCasilleroDetalle detalle ;
	private VistaCasilleroJugadores jugadores ;	
	
	
	public ContenedorCasillero(String nombreCasillero){
		this.getStyleClass().add("VistaCasillero");
		nombre = new VistaCasilleroNombre(nombreCasillero);
		detalle = new VistaCasilleroDetalle();
		jugadores = new VistaCasilleroJugadores();
		
		nombre.setPrefHeight(this.getPrefHeight()/3);
		detalle.setPrefHeight(this.getPrefHeight()/3);
		jugadores.setPrefHeight(this.getPrefHeight()/3);
		this.getChildren().addAll(nombre,detalle,jugadores);

	}
	
	
	
	

}
