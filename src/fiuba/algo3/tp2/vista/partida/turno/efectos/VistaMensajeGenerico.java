package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.botones.BotonComprar;
import fiuba.algo3.tp2.vista.botones.BotonMensajeGenerico;
import javafx.scene.control.Label;

public class VistaMensajeGenerico extends VistaAccion{

	public VistaMensajeGenerico(String mensaje, VistaAccion vista_siguiente){
		Label label = new Label(mensaje);
		BotonMensajeGenerico boton = new BotonMensajeGenerico(vista_siguiente);
		this.getChildren().addAll(label, boton);
	}
	
}
