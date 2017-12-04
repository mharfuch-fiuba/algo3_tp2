package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.botones.BotonPagarAlquiler;
import javafx.scene.control.Label;

public class VistaPropiedadAjena extends VistaAccion{

	public VistaPropiedadAjena(){
		Label label = new Label("Caiste en una propiedad ajena.");
		BotonPagarAlquiler boton = new BotonPagarAlquiler();
		this.getChildren().addAll(label,boton);
	}
	
}
