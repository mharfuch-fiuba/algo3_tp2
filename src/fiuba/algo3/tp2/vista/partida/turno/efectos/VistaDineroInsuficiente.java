package fiuba.algo3.tp2.vista.partida.turno.efectos;

import javafx.scene.control.Label;
import fiuba.algo3.tp2.vista.botones.BotonVender;


public class VistaDineroInsuficiente extends VistaAccion {

	public VistaDineroInsuficiente(){
		Label label = new Label("No tenes Dinero para pagar!");
		BotonVender botonVender = new BotonVender();
		this.getChildren().addAll(label,botonVender);
	}
}
