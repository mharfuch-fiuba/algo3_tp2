package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.botones.BotonTerminarTurno;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;
import javafx.scene.control.Label;

public class VistaPropiedadPropia extends VistaEfecto{

	public VistaPropiedadPropia(ContenedorTurno padre){
		Label label = new Label("Caiste en una propiedad tuya.");
		BotonTerminarTurno boton = new BotonTerminarTurno(padre);
		this.getChildren().addAll(label,boton);
	}
	
}
