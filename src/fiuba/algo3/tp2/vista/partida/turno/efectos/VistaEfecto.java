package fiuba.algo3.tp2.vista.partida.turno.efectos;

import javafx.scene.layout.VBox;

public abstract class VistaEfecto extends VBox {
	
	private String descripcion;
	
	public void setDescrpcion(String descripcion){
		this.descripcion = descripcion;
	}
	
	public VistaEfecto(){
		this.getStyleClass().add("VistaEfecto");
	}
	
	
}
