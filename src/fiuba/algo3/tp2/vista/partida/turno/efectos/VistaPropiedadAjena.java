package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.botones.BotonTerminarTurno;
import javafx.scene.control.Label;

public class VistaPropiedadAjena extends VistaAccion{

	public VistaPropiedadAjena(){
		Label label = new Label("Caiste en una propiedad ajena.");
		BotonTerminarTurno boton = new BotonTerminarTurno();
		this.getChildren().addAll(label,boton);
	}
	
}
