package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.vista.botones.eventos.BotonProponerIntercambioHandler;
import javafx.scene.control.ComboBox;

public class BotonProponerIntercambio extends BotonAlgoPoly {

	public BotonProponerIntercambio(ComboBox<Propiedad> combo_propiedades, ComboBox<Jugador> combo_jugadores) {
		this.setText("Confirmar");
		this.setOnAction(new BotonProponerIntercambioHandler(combo_propiedades,combo_jugadores));
	}

}
