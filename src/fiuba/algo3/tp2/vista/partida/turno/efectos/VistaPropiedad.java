package fiuba.algo3.tp2.vista.partida.turno.efectos;

import javafx.scene.control.Label;

public class VistaPropiedad extends VistaEfecto{
	
	public VistaPropiedad(){
		Label label = new Label("soy propiedad");
		this.getChildren().add(label);
	}

}
