package fiuba.algo3.tp2.vista.partida.turno.efectos;

import javafx.scene.control.Label;
import java.util.ArrayList;

import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.vista.botones.BotonVender;


public class VistaDineroInsuficiente extends VistaAccion {

	public VistaDineroInsuficiente(ArrayList<Propiedad> propiedades){
		Label label = new Label("No tenes Dinero para pagar!");
		BotonVender botonVender = new BotonVender(propiedades);
		this.getChildren().addAll(label,botonVender);
	}
}
