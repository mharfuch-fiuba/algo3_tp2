package fiuba.algo3.tp2.vista.botones;

import java.util.ArrayList;

import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.vista.botones.eventos.BotonVenderHandler;

public class BotonVender extends BotonAlgoPoly {

	public BotonVender(ArrayList<Propiedad> propiedades) {
		this.setText("Vender");
		this.setOnAction(new BotonVenderHandler(propiedades));
	}

}
