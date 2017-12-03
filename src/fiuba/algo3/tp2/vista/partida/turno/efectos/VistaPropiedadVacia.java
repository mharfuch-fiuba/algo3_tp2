package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.botones.BotonComprar;
import fiuba.algo3.tp2.vista.botones.BotonTerminarTurno;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;
import javafx.scene.control.Label;

public class VistaPropiedadVacia extends VistaEfecto {

	public VistaPropiedadVacia(ContenedorTurno padre) {		
		Label label = new Label("Caiste en una propiedad vacia che");
		BotonComprar boton_comprar = new BotonComprar(padre);
		BotonTerminarTurno boton_terminar = new BotonTerminarTurno(padre);
		this.getChildren().addAll(label,boton_comprar, boton_terminar);
	}
}
