package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.botones.BotonTerminarTurno;
import javafx.scene.control.Label;

public class VistaPropiedadPropia extends VistaAccion{

	public VistaPropiedadPropia(){
		Label label = new Label("Caiste en una propiedad tuya.");
		BotonTerminarTurno boton = new BotonTerminarTurno(null);
		this.getChildren().addAll(label,boton);
	}
	
}
