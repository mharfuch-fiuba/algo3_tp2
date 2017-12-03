package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.botones.BotonComprar;
import fiuba.algo3.tp2.vista.botones.BotonTerminarTurno;
import javafx.scene.control.Label;

public class VistaPropiedadLibre extends VistaAccion{

	public VistaPropiedadLibre(){
		Label label = new Label("Caiste en una propiedad libre.");
		BotonComprar comprar = new BotonComprar();
		BotonTerminarTurno boton = new BotonTerminarTurno();
		this.getChildren().addAll(label,boton);
	}
	
}
