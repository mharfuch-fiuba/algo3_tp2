package fiuba.algo3.tp2.vista.partida.casillero;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ContenedorCasillero extends VBox{
	
	private VistaCasilleroNombre nombre;
	private VistaCasilleroDetalle detalle ;
	private VistaCasilleroJugadores jugadores ;	
	
	public ContenedorCasillero(String nombreCasillero,Color color){
		this.getStyleClass().add("VistaCasillero");
		nombre = new VistaCasilleroNombre(nombreCasillero,color);
		detalle = new VistaCasilleroDetalle();
		jugadores = new VistaCasilleroJugadores();
		
		//nombre.setPrefHeight(this.getPrefHeight()/3);
		detalle.setPrefHeight(this.getPrefHeight()/3);
		jugadores.setPrefHeight(this.getPrefHeight()/3);
		//nombre.setPrefWidth(this.getPrefWidth());
		detalle.setPrefWidth(this.getPrefWidth());
		jugadores.setPrefWidth(this.getPrefWidth());
		this.getChildren().addAll(nombre,detalle,jugadores);

	}
	
	public VistaCasilleroJugadores getJugadores(){
		return this.jugadores;
	}
	
	public void actualizarDetalle(VistaCasilleroDetalle vistaDetalle){
		this.detalle=vistaDetalle;
		//remplazar la vista detalle
		//this.getChildren().replaceAll(operator);
	}
	
	public void borrarJugador(VistaCasilleroJugador vista) {
		jugadores.sacarJugador(vista);
	}

	public void dibujarJugador(VistaCasilleroJugador vista) {
		jugadores.ponerJugador(vista);
	}
	
}
