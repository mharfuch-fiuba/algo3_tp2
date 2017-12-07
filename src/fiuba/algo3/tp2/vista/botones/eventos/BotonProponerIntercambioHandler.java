package fiuba.algo3.tp2.vista.botones.eventos;

import fiuba.algo3.tp2.controlador.ControladorPrincipal;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

public class BotonProponerIntercambioHandler implements EventHandler<ActionEvent> {

	private ComboBox<Propiedad> combo_propiedades;
	private  ComboBox<Jugador> combo_jugadores;

	public BotonProponerIntercambioHandler(ComboBox<Propiedad> combo_propiedades, ComboBox<Jugador> combo_jugadores) {
		this.combo_jugadores = combo_jugadores;
		this.combo_propiedades = combo_propiedades;
	}

	@Override
	public void handle(ActionEvent event) {
		ControladorPrincipal.getInstance().accionProponerIntercambio(combo_propiedades.getValue(), combo_jugadores.getValue());
	}

}
