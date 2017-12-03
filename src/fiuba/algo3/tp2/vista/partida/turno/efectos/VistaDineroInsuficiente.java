package fiuba.algo3.tp2.vista.partida.turno.efectos;

import javafx.scene.control.Label;
import fiuba.algo3.tp2.vista.botones.BotonVender;


public class VistaDineroInsuficiente extends VistaEfecto {

	public VistaDineroInsuficiente(){
		Label label = new Label("No tenes Dinero para pagar!");
		BotonVender botonVender = new BotonVender(null);
		BotonContinuar botonContinuar = new BotonContinuar(null);
		this.getChildren().addAll(label,botonVender,botonContinuar);
	}
}
